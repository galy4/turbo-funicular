let resourceType = "";
$(document).ready(()=> {

    getAllWagons();
    $('#kafka,#crt').hide();

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

    $("#forward").click(sendForward);
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
    $('#forward').hide();
    if(resourceType==='internal'){
        $("#far,#inv,#crt").hide();
        $("#inner").show();
    }else {
        $("#inner").hide();
        $("#far,#inv,#crt").show();
    }
}

function sendFarArrival(){
    let inv = $('#invoice').val();
    $.post(`/farArrival/${inv}`, function (){
        console.log(`Far arrival data sent to backend`);
        $('#far').css('background', 'grey');
    });
}

function sendInvoice(){
    let inv = $('#invoice').val();
    $.post(`/invoice/${inv}`, function (){
        console.log(`Invoice data sent to backend`);
        $('#inv').css('background', 'grey');
    });
}

function sendCurrentLocation(){
    let path = $('#path').val();
    let time = $('#time').val();
    $.post(`/currentLocation/${path}&${time}`, function () {
        console.log(`Current location data sent to backend`);
        $('#cur').css('background', 'grey');
        $('#forward').show();
    });
}

function sendWeighing(){
    let brutto = $('#brutto').val();
    let tare = $('#tare').val();
    $.post(`/weght?brutto=${brutto}&tare=${tare}&isExternal=${resourceType}`,
        ()=>{console.log(`weighing data sent to backend`);
        $('#weigh').css('background', 'grey');
    });
}

function sendInnerInvoice(){
    let inv = $('#invoice').val();
    $.post(`/innerInvoice/${inv}`, function (){
        console.log(`Invoice data sent to backend`);
        $('#inner').css('background', 'grey');
    });
}

function sendForward(){
    let inv = $('#invoice').val();
    let newInv = $('#newInvoice').val();
    $.post(`/forward?newInvoice=${newInv}&oldInvoice=${inv}`, function (){
        console.log(`Invoice data sent to backend`);
        $('#forward').css('background', 'grey');
    });
}


