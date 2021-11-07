$.getJSON('/wagons', function(data){
    // let table = document.getElementById("info").getElementsByTagName("TBODY")[0];
    // $.each(data, function(key, val){
    //     addRow();
    //     let k = 1;
    //     $.each(val, function (key1, val1){
    //         table.getElementsByTagName("tr")[key+1].getElementsByTagName("td")[k].innerHTML = val1;
    //         table.getElementsByTagName("tr")[key+1]
    //             .getElementsByTagName("td")[k]
    //             .getElementsByTagName("input")[0].value = val1;
    //         k++;
    //     });
    //
    // });
    $('#info').append(`
                  <tbody>${data.map(n => `
                    <tr>
                      <td>${n.id}</td>
                      <td>${n.number}</td>
                      <td>${n.weight}</td>
                      <td>${n.type}</td>
                    </tr>`).join('')}
                  </tbody>
`           );
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