$(document).ready(function () {
    let wagonId = 0;

    $.getJSON('/wagon', function (data) {
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

    $("#q").click(function () {
        if (wagonId === 0) {
            alert("No row for update selected");
        } else {
            updateWagon({
                "id": wagonId,
                "number": $("#number").val(),
                "weight": $("#weight").val(),
                "type": $("#type").val()
            });
        }
    });

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
    $('.modalwindow .close').click(function (e) {
        //Отменяем поведение ссылки
        e.preventDefault();
        $('.modalwindow').fadeOut(500);
    });

    $("#add1").click(function () {
        $.ajax({
            type: 'POST',
            url: '/wagon',
            contentType: 'application/json',
            data: JSON.stringify({
                "id": 0,
                "number": $("#newNum").val(),
                "weight": $("#newWeight").val(),
                "type": $("#newType").val()
            }), // access in body
        }).done(function () {
            console.log('SUCCESS');
        }).fail(function (msg) {
            console.log('FAIL');
        }).always(function (msg) {
            console.log('ALWAYS');
        });
    });

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
            data: JSON.stringify( {
                "id": 0,
                "number": $("#number").val(),
                "weight": $("#weight").val(),
                "type": $("#type").val()
        }), // access in body
        }).done(function () {
            window.location.reload(true);
            console.log('SUCCESS');
        }).fail(function (msg) {
            console.log('FAIL');
        }).always(function (msg) {
            console.log('ALWAYS');
        });
    }
});





