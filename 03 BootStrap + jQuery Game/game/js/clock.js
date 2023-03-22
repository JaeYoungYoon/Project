setInterval(function () {
  date = new Date();
  $(".clock").html(
    "<h3>" +
      (date.getHours() / 12 == 0 ? "오전 " : "오후 ") +
      (date.getHours() % 12) +
      "시 " +
      date.getMinutes() +
      "분 " +
      date.getSeconds() +
      "초</h3>"
  );
}, 1000);
