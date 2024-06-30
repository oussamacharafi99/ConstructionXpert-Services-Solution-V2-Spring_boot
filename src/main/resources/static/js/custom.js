
  $(function () {

    // MENU
    $('.navbar-collapse a').on('click',function(){
      $(".navbar-collapse").collapse('hide');
    });

    // AOS ANIMATION
    AOS.init({
      disable: 'mobile',
      duration: 800,
      anchorPlacement: 'center-bottom'
    });


    // SMOOTHSCROLL NAVBAR
    $(function() {
      $('.navbar a, .hero-text a').on('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top - 49
        }, 1000);
        event.preventDefault();
      });
    });
  });


  function scrolling(value1, value2) {
    const projectView = document.querySelector('.main-right');
    const menu = document.querySelector('.border-menu');
    projectView.scrollTo({top: value1, behavior: 'smooth'});
    menu.style.transition = ".6s"
    menu.style.top = value2 + "px";
  }

  document.querySelector('.main-right').addEventListener('scroll', () => {
    const projectView = document.querySelector('.main-right');
    const menu = document.querySelector('.border-menu');

    if (projectView.scrollTop >= 0 && projectView.scrollTop < 446) {
      menu.style.transition = ".6s";
      menu.style.top = "10px";
    } else if (projectView.scrollTop >= 446 && projectView.scrollTop < 1053) {
      menu.style.transition = ".6s";
      menu.style.top = "95px";
    } else if (projectView.scrollTop >= 1053 && projectView.scrollTop < 1431) {
      menu.style.transition = ".6s";
      menu.style.top = "170px";
    } else if (projectView.scrollTop >= 1431) {
      menu.style.transition = ".6s";
      menu.style.top = "255px";
    }
  });




  document.addEventListener("DOMContentLoaded", function () {
    const cardTasks = document.querySelectorAll(".task-card");
    const  idP = document.getElementById("idP");
    cardTasks.forEach(card => {
      const btnDeleteTask = card.querySelector(".deleteTask");
      btnDeleteTask.addEventListener("click", () => {
        const taskId = btnDeleteTask.getAttribute("value");
        const projectId = idP.value;
        document.querySelector(".deleteTaskSure").href = `/deleteTask?id=${taskId}&idP=${projectId}`;
      });
    });
  });

  document.addEventListener("DOMContentLoaded", function () {
    const cardTasks = document.querySelectorAll(".resource-card");
    const  idP = document.getElementById("idP");
    cardTasks.forEach(card => {
      const btnDeleteTask = card.querySelector(".deleteRes");
      btnDeleteTask.addEventListener("click", () => {
        const ResTas = btnDeleteTask.getAttribute("value");
        const projectId = idP.value;
        document.querySelector(".deleteResource").href = `/deleteResource?id=${ResTas}&idP=${projectId}`;
      });
    });
  });


  document.addEventListener("DOMContentLoaded", function() {
    const statuses = document.querySelectorAll("#status");

    statuses.forEach(function(status) {
      switch (status.textContent.trim().toLowerCase()) {
        case "to do":
          status.style.background = "#09b1e4";
          break;
        case "in progress":
          status.style.background = "#3ff45b";
          break;
        case "completed":
          status.style.background = "#d32828";
          break;
        default:
          status.style.background = "#ffffff"; // Default color if none match
      }
    });
  });