
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


const add_project = document.querySelector(".project");


  function scrolling(value1, value2) {
    const projectView = document.querySelector('.main-right');
    const menu = document.querySelector('.border-menu');
    projectView.scrollTo({top: value1, behavior: 'smooth'});
    menu.style.transition = ".6s"
    menu.style.top = value2 + "px";
  }



  document.addEventListener("DOMContentLoaded", function () {
    const cardTasks = document.querySelectorAll(".task-card");

    cardTasks.forEach(card => {
      const btnDeleteTask = card.querySelector(".deleteTask");
      btnDeleteTask.addEventListener("click", () => {
        const taskId = btnDeleteTask.getAttribute("value");
        document.querySelector(".deleteTaskSure").href = `/DeleteTask?id=${taskId}`;
      });
    });
  });

