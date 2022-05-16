document.addEventListener("DOMContentLoaded", function () {
// Make it as accordion for smaller screens
    if (window.innerWidth < 992) {
        // Close all inner dropdowns when parent is closed
        document.querySelectorAll('.navbar .dropdown').forEach(function (everyDropdown) {
            everyDropdown.addEventListener('hidden.bs.dropdown', function () {
                // After dropdown is hidden, then find all submenus
                this.querySelectorAll('.submenu').forEach(function (everySubmenu) {
                    // Hide every submenu as well
                    everySubmenu.style.display = 'none';
                });
            })
        });

        document.querySelectorAll('.dropdown-menu a').forEach(function (element) {
            element.addEventListener('click', function (e) {
                let nextEl = this.nextElementSibling;
                if (nextEl && nextEl.classList.contains('submenu')) {
                    // Prevent opening link if link needs to open dropdown
                    e.preventDefault();
                    if (nextEl.style.display === 'block') {
                        nextEl.style.display = 'none';
                    } else {
                        nextEl.style.display = 'block';
                    }
                }
            });
        })
    } // End-if innerWidth
}); // End DOMContentLoaded
