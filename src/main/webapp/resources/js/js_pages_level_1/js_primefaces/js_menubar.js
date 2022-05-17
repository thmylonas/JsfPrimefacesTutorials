//<![CDATA[

$(document).ready(function () { // Change the "submenuId"
    setMegaMenuTimeout("#submenuId", 10);
});

function setMegaMenuTimeout(menuId, mSeconds) {

    let menuTimer = null;
    let parentMenuItems = $(menuId).find('.ui-menu-parent');

    parentMenuItems.each(function () {
        let dropDown = $(this).children("ul").eq(0);
        let subLinkMenuItems = $(dropDown).find('.ui-submenu-link');

        if (subLinkMenuItems != null) {
            subLinkMenuItems.each(function () {
                let subMenu = $(this).children("ul").eq(0);
                menuTimer = addBehaviour(subMenu, menuId, mSeconds);
            });
        } else {
            menuTimer = addBehaviour(dropDown, menuId, mSeconds);
        }
    });

    $(document).on('mouseover', menuId, function (e) {
        if (menuTimer !== null) {
            console.log("The event " + e + " is not used in this function!");
            window.clearTimeout(menuTimer);
        }
    });
}

function addBehaviour(menuItem, menuId, mSeconds) {

    let menuTimer = null;

    menuItem.mouseout(function () {
        menuTimer = window.setTimeout(function () {
            closeMegaMenu(menuId);
        }, mSeconds);
    });
    menuItem.mouseover(function () {
        if (menuTimer !== null) {
            window.clearTimeout(menuTimer);
        }
    });
    return menuTimer;
}

function closeMegaMenu(menuId) {

    let parentMenuItem = $(menuId).find("li:not(.ui-menu-parent.ui-menuitem-active:has(.ui-menu-parent.ui-menuitem-active))");

    parentMenuItem.each(function () {
        $(this).children("ul").eq(0).hide('fast');
        $(this).removeClass("ui-menuitem-active");
        $(this).children("a").eq(0).removeClass("ui-state-hover");
    });

    let hovered = $(menuId).find('.ui-menu-list:hover');
    if (hovered.length === 0) {
        parentMenuItem = $(menuId).find(".ui-menu-parent.ui-menuitem-active");
        parentMenuItem.each(function () {
            $(this).children("ul").eq(0).hide('fast');
            $(this).removeClass("ui-menuitem-active");
        });
    }
}

//]]>
