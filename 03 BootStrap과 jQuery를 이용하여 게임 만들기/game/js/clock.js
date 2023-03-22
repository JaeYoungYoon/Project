setInterval(function () {
  date = new Date();
  $(".clock").html(
    "<h3>" +
      (date.getHours() / 12 == 0 ? "午前 " : "午後 ") +
      (date.getHours() % 12) +
      "時 " +
      date.getMinutes() +
      "分 " +
      date.getSeconds() +
      "秒</h3>"
  );
}, 1000);
