const toggleBtn = document.querySelector('.menu-btn');
const menu = document.querySelector('.nav-btn');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});

