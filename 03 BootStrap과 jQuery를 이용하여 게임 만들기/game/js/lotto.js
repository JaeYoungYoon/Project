$(document).ready(function () {
  $("#lottopush").click(function () {
    $(".lottobox").children().remove();
    var lottoArray = new Array(6);

    function getRandom() {
      var random = Math.random() * 45 + 1;
      var num = Math.floor(random);
      return num;
    }

    for (var i = 0; i < lottoArray.length; i++) {
      lottoArray[i] = getRandom();

      for (var j = 0; j < i; j++) {
        if (lottoArray[i] == lottoArray[j]) {
          i--;
          break;
        }
      }
    }
    $(lottoArray).each(function (index, value) {
      var lottoDiv = $("<div>")
        .addClass("lotto")
        .text(value + " ");
      if (value >= 1 && value <= 10) {
        lottoDiv.addClass("yellow");
      } else if (value >= 11 && value <= 20) {
        lottoDiv.addClass("lightblue");
      } else if (value >= 21 && value <= 30) {
        lottoDiv.addClass("salmon");
      } else if (value >= 31 && value <= 40) {
        lottoDiv.addClass("lightgrey");
      } else {
        lottoDiv.addClass("yellowgreen");
      }
      $(".lottobox").append(lottoDiv);
    });
  });
});
