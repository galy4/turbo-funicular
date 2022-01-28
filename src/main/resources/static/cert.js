$(document).ready(()=> {

    getAllWagons();
    getAllQualityIndicators();

    $("#indicatorData").click(addChemistryData);
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

function getAllQualityIndicators(){
    $.getJSON(`/indicator`, (items) =>{
        $.each(items, (key, value)=> {
            $('#indicator')
                .append($("<option></option>")
                    .attr("value", key)
                    .text(value));
        });
    });
}

function addChemistryData(){
    let opt = $("#indicator option:selected").text();
    let num = $('#v').val();
    $.getJSON(`/indicator/${opt}&${num}`,
        function (data) {
            $.each(data, function (key, value){
                $('.chemList').append("<p>" + key+ " : " + value + "</p>")
            });
        });
}
