        $(function () {
            var table = $("<table>").attr("border", "1").addClass("table table-bordered table-success"); // addClass
            var headerRow = $("<thead>");
            headerRow.append($("<th>"));

            for (var i = 2; i <= 9; i++) {
                var headerCell = $("<th>").text(i + "단");
                headerRow.append(headerCell);
            }
            table.append(headerRow);

            var bodyRow = $("<tbody>");
            for (var j = 1; j <= 9; j++) {
                var row = $("<tr>");
                var firstCell = $("<td>").text(j);
                row.append(firstCell);
                for (var i = 2; i <= 9; i++) {
                    var cell = $("<td>").text(i + " x " + j + " = " + i * j);
                    row.append(cell);
                }
                bodyRow.append(row);
            }


            table.append(bodyRow);
            $("#gugudan").append(table);
        });