$(document).ready(function () {
    $.getJSON('/wagons', function (data) {
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
            let i = $(this).children()[0].textContent;
            getWagon(i);
        });

        $("#q").click(function () {

        });

    });


    function getWagon(id1) {
        $.getJSON(`/wagon/${id1}`,
            function (data) {
                $("#number").val(data.number);
                $("#weight").val(data.weight);
                $("#type").val(data.type);
            });
    }


});

// function addRow(){
//     let tbody = document.getElementById("info").getElementsByTagName("TBODY")[0];
//     let row = document.createElement("TR")
//     for (let i=0;i<4;i++){
//         let td = document.createElement("TD")
//         // td.appendChild(document.createTextNode("column " + i))
//         row.appendChild(td);
//         let input = document.createElement("input");
//         input.setAttribute('type', 'text');
//         td.appendChild(input);
//     }
//     tbody.appendChild(row);
// }
