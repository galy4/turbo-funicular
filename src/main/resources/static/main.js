$(document).ready(function () {
    let wagonId=0;

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
        if(wagonId===0){
            alert("No row for update selected")
        }else {
            let data = {
                "id": wagonId,
                "number": $("#number").val(),
                "weight": $("#weight").val(),
                "type": $("#type").val()
            }
            updateWagon(data);
        }
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

function updateWagon(data){
    $.ajax({
        type: 'PUT',
        url: '/wagon',
        contentType: 'application/json',
        data: JSON.stringify(data), // access in body
    }).done(function () {
        window.location.reload(true);
        console.log('SUCCESS');
    }).fail(function (msg) {
        console.log('FAIL');
    }).always(function (msg) {
        console.log('ALWAYS');
    });
}



