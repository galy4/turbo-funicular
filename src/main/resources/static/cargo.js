let resourceType = "";
$(document).ready(()=> {

    getAllWagons();
    $('#kafka').hide();
    $("#q").click(() => {
        if (wagonId === 0) {
            alert("No row for update selected");
            return;
        }
        updateWagon({
            id: wagonId,
            number: $("#number").val(),
            weight: $("#weight").val(),
            type: $("#type").val()
        });
    });

    $('input[name="int_ext"]').click( ()=> {
        readResources($("input[type='radio']:checked").val());
    });

    //-------wagon lifecycle-----
    $('#resourceData').click(()=>{
        getNSIResourceData();
    });

    $("#far").click(sendFarArrival);

    $("#inner").click(sendInnerInvoice);

    $("#inv").click(sendInvoice);

    $("#cur").click(sendCurrentLocation);

    $("#weigh").click(sendWeighing);
});

function getAllWagons(){
    $('#info tbody').remove();
    $.getJSON('/wagon', (data)=> {
        $('#info').append(`
                  <tbody>${data.map(n => `
                    <tr>
                      <td>${n.id}</td>
                      <td>${n.number}</td>
                      <td>${n.weight}</td>
                      <td>${n.type}</td>
                    </tr>`).join('')}
                  </tbody>
`);
    });
}

function readResources(type){
    resourceType = type;
    $('#resources').find('option').remove();
    $.getJSON(`/resource/${type}`, (items) =>{
        $.each(items, (key, value)=> {
            $('#resources')
                .append($("<option></option>")
                    .attr("value", key)
                    .text(value));
        });
    });
}

function getNSIResourceData(){
    let opt = $("#resources option:selected").text();
    $('.resource').find('p').remove();
    $.getJSON(`/resourceData/${opt}/${resourceType}`,
        function (data) {
            $.each(data, function (key, value){
                $('.resource').append("<p>" + key+ " : " + value + "</p>")
            });
        });
    $('#kafka').fadeIn(1000);
    if(resourceType==='internal'){
        $("#far,#inv").hide();
        $("#inner").show();
    }else {
        $("#inner").hide();
        $("#far,#inv").show();
    }
}

function sendFarArrival(){
    let inv = $('#invoice').val();
    $.post(`/farArrival/${inv}`, function (){
        console.log(`Far arrival data sent to backend`);
    });
}

function sendInvoice(){
    let inv = $('#invoice').val();
    $.post(`/invoice/${inv}`, function (){
        console.log(`Invoice data sent to backend`);
    });
}

function sendCurrentLocation(){
    let path = $('#path').val();
    let time = $('#time').val();
    $.post(`/currentLocation/${path}&${time}`, function () {
        console.log(`Current location data sent to backend`);
    });
}

function sendWeighing(){
    let brutto = $('#brutto').val();
    let tare = $('#tare').val();
    $.post(`/weght?brutto=${brutto}&tare=${tare}&isExternal=${resourceType}`,
        ()=>{console.log(`weighing data sent to backend`);
        });
}

function sendInnerInvoice(){
    let inv = $('#invoice').val();
    $.post(`/innerInvoice/${inv}`, function (){
        console.log(`Invoice data sent to backend`);
    });
}


