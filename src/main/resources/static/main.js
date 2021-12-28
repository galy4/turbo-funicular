let wagonId = 0;
$(document).ready(()=>{

    getAllWagons();
    $('#kafka').hide();
    $("#q").click(()=> {
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

    readResources();

    //Обработчики:

    //выбираем все теги с именем  modal
    $('a[name=modal]').click(function (e) {
        //Отменяем поведение ссылки
        e.preventDefault();
        //Получаем тег A
        let id = $(this).attr('href');
        //Получаем ширину и высоту окна
        const winH = $(window).height();
        const winW = $(window).width();
        //Устанавливаем всплывающее окно по центру
        $(id).css('top', winH / 2 - $(id).height() / 2);
        $(id).css('left', winW / 2 - $(id).width() / 2);
        //эффект перехода
        $(id).fadeIn(500);
    });

    //если нажата кнопка закрытия окна
    $('.modalwindow .close').click((e)=> {
        //Отменяем поведение ссылки
        e.preventDefault();
        $('.modalwindow').fadeOut(500);
    });

    $("#add1").click(()=> {
        createWagon();
    });

    $("#clone").click(()=> {
        cloneWagon();
    });

    $('#resourceData').click(()=>{
       getNSIResourceData();
    });

    //-------wagon lifecycle-----
    $("#far").click(()=> {
        sendFarArrival();
    });

    $("#inv").click(()=> {
        sendInvoice();
    });

    $("#cur").click(()=> {
        sendCurrentLocation();
    });

    $("#weigh").click(()=> {
        sendWeighing();
    });


});
//Функции:
function getWagon(id) {
    $.getJSON(`/wagon/${id}`,
        function (data) {
            $("#number").val(data.number);
            $("#weight").val(data.weight);
            $("#type").val(data.type);
        });
}

function updateWagon(data) {
    $.ajax({
        type: 'PUT',
        url: '/wagon',
        contentType: 'application/json',
        data: JSON.stringify(data), // access in body
    }).done(function () {
        getAllWagons();
        console.log('data reloaded with ajax');
    }).fail(function (msg) {
        console.log('FAIL');
    }).always(function (msg) {
        console.log('example of always action');
    });
}

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

        $("tbody tr").click(function () {
            wagonId = $(this).children()[0].textContent;
            getWagon(wagonId);
        });
    });
}

function createWagon(){
    $.ajax({
        type: 'POST',
        url: '/wagon',
        contentType: 'application/json',
        data: JSON.stringify({
            id: 0,
            number: $("#newNum").val(),
            weight: $("#newWeight").val(),
            type: $("#newType").val()
        }), // access in body
    }).done(function () {
        console.log(`data sent to backend`);
    });
}

function readResources(){
    $.getJSON( "/resource", (items) =>{
        $.each(items, (key, value)=> {
            $('#resources')
                .append($("<option></option>")
                    .attr("value", key)
                    .text(value));
        });
    });
}

function getNSIResourceData(){
    let opt = $( "#resources option:selected" ).text();
    $.getJSON(`/resource/${opt}`,
        function (data) {
            $.each(data, function (key, value){
                $('body').append("<p>" + key+ " : " + value + "</p>")
            });
        });
    $('#kafka').fadeIn(1000);
}

function sendFarArrival(){
    let inv = $('#invoice').val();
    $.post(`/farArrival/${inv}`, function (){
        console.log(`Far arrival data sent to backend`);
        $("#far").prop("disabled",true);
        });
}

function sendInvoice(){
    let inv = $('#invoice').val();
    $.post(`/invoice/${inv}`, function (){
        console.log(`Invoice data sent to backend`);
        $("#inv").prop("disabled",true);
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
    $.post(`/weigh/${brutto}&${tare}`, function (){
        console.log(`weighing data sent to backend`);
    });
}

function cloneWagon(){
    let lastRow = $('tbody tr').last();
    $.ajax({
        type: 'POST',
        url: '/wagon',
        contentType: 'application/json',
        data: JSON.stringify({
            id: 0,
            number: Number(lastRow.last().children()[1].textContent) + 1,
            weight: lastRow.last().children()[2].textContent,
            type: lastRow.last().children()[3].textContent
        }), // access in body
    }).done(function () {
        console.log(`data sent to backend`);
        getAllWagons();
    });
}




