$(document).ready(function () {
  var table = $("<table>").addClass("table table-bordered table-primary");
  var headerRow = $("<tr>");
  headerRow.append($("<td>"));

  for (var i = 2; i <= 9; i++) {
    var headerCell = $("<th>").text(i + "단");
    headerRow.append(headerCell);
  }
  table.append(headerRow);

  for (var j = 1; j <= 9; j++) {
    var row = $("<tr>");
    var firstCell = $("<td>").text(j);
    row.append(firstCell);

    for (var i = 2; i <= 9; i++) {
      var cell = $("<td>").text(i + " x " + j + " = " + i * j);
      row.append(cell);
    }
    table.append(row);
  }

  $("#gugudan").append(table);
});
