
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



  document.addEventListener("DOMContentLoaded", function () {
    const cardTasks = document.querySelectorAll(".task-card");
    const  idP = document.getElementById("idP");
    cardTasks.forEach(card => {
      const btnDeleteTask = card.querySelector(".deleteTask");
      btnDeleteTask.addEventListener("click", () => {
        const taskId = btnDeleteTask.getAttribute("value");
        const projectId = idP.value;
        document.querySelector(".deleteTaskSure").href = `/DeleteTask?id=${taskId}&idP=${projectId}`;
      });
    });
  });


  document.addEventListener("DOMContentLoaded", function() {
    const statuses = document.querySelectorAll("#status");

    statuses.forEach(function(status) {
      switch (status.textContent.trim().toLowerCase()) {
        case "to do":
          status.style.background = "#00c3ff";
          break;
        case "in progress":
          status.style.background = "#76ff8b";
          break;
        case "completed":
          status.style.background = "#ff0000";
          break;
        default:
          status.style.background = "#ffffff"; // Default color if none match
      }
    });
  });