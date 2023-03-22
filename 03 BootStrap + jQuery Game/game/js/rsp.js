$(document).ready(function () {
  function ComputerRspPlayer(yourRsp) {
    this.rsp = ["グー", "チョキ", "パー"]; // じゃんけん
    this.img = ["./image/グー.png", "./image/チョキ.png", "./image/パー.png"]; // イメージを準備する。

    this.computerRsp = this.rsp[Math.floor(Math.random() * 3)]; // 0,1,2の中で選ぶ。

    this.getResult = function () {
      var result = "同じです"; // 結果を教える。

      if (this.computerRsp == yourRsp) return result; // 結果が同じ

      if (this.computerRsp == "グー") {
        // ロボットがグーなら

        if (yourRsp == "パー")
          // 私がパー
          result = "あなたの勝ちです!!"; // 私が勝ち
        else if (yourRsp == "チョキ")
          // 私がチョキ
          result = "残念…"; // 私が負け
      } else if (this.computerRsp == "チョキ") {
        // ロボットがチョキなら

        if (yourRsp == "グー")
          // 私がグー
          result = "あなたの勝ちです!!"; // 私が勝ち
        else if (yourRsp == "パー")
          // 私がパー
          result = "残念…"; // 私が負け
      } else if (this.computerRsp == "パー") {
        // ロボットがパーなら

        if (yourRsp == "チョキ")
          // 私がチョキ
          result = "あなたの勝ちです!!"; // 私が勝ち
        else if (yourRsp == "グー")
          // 私がグー
          result = "残念…"; // 私が負け
      }
      return result;
    };
  }

  $(".your-rsp").each(function (index, item) {
    // 私がボタンを押した時は、配列を繰り返して機能を与える。

    $(this).click(function () {
      var rspPlayer = new ComputerRspPlayer($(this).text().trim()); // 作った関数で呼んで、変数の中で置く。
      var result = rspPlayer.getResult(); // 結果をもらう。
      $("#rsp-result").text(result); // 結果を表示。
      $("#rsp-img-your")
        .attr("src", "./image/" + $(this).text().trim() + ".png")
        .attr("width", "200px")
        .attr("height", "250px"); // じゃんけんのイメージを表示。
      $("#rsp-img-computer")
        .attr("src", "./image/" + rspPlayer.computerRsp + ".png")
        .attr("width", "200px")
        .attr("height", "250px"); // じゃんけんのイメージを表示。
      $("#rsp-btn-computer").text(rspPlayer.computerRsp); // ロボットのじゃんけんの結果を表示。
    });
  });
});
