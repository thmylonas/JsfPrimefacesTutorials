package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer._enums;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;

import java.util.Arrays;

public enum ImagesEnum {

    // "images/java_frameworks"
    JAVA_SERVER_FACES_IMAGE("JavaServerFaces", ".jpg", "JavaServer Faces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    PRIMEFACES_IMAGE("Primefaces", ".png", "Primefaces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    SPRING_FRAMEWORK_IMAGE("SpringFramework", ".png", "Spring Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),

    // "images/social_media"
    FACEBOOK_IMAGE("Facebook", ".png", "Facebook", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),
    GOOGLE_PLUS_IMAGE("GooglePlus", ".png", "GooglePlus", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),
    INSTAGRAM_IMAGE("Instagram", ".png", "Instagram", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),
    LINKEDIN_IMAGE("LinkedIn", ".png", "LinkedIn", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),

    // "images/navigation_btns"
    BACK_TO_HOME_IMAGE("BackToHome", ".png", "Back Home", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_NAVIGATION_BTNS_DIR),
    BACK_TO_TOP_IMAGE("BackToTop", ".png", "Back to Top", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_NAVIGATION_BTNS_DIR),

    // "images/about"
    THOMAS_MYLONAS_IMAGE("ThomasMylonas", ".jpg", "Thomas Mylonas", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),

    // "images/backgrounds"
    JAVA_CODING_BG_IMAGE("JavaCodingBg", ".jpg", "JavaCodingBg", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_BACKGROUNDS_DIR),
    PINK_BG_IMAGE("PinkBg", ".jpg", "PinkBg", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_BACKGROUNDS_DIR),
    RED_BG_IMAGE("RedBg", ".jpg", "RedBg", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_BACKGROUNDS_DIR),

    // "images/langs"
    EN_IMAGE("En", ".png", "English Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_LANGS_DIR),
    GR_IMAGE("Gr", ".jpg", "Greek Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_LANGS_DIR),

    // "images/menubar_icons/java_frameworks"
    MENUBAR_ICON_JAVA_SERVER_FACES_IMAGE("JavaServerFaces", ".png", "JavaServer Faces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_PRIMEFACES_IMAGE("Primefaces", ".png", "Primefaces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_SPRING_FRAMEWORK_IMAGE("SpringFramework", ".png", "Spring Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),

    // "images/menubar_icons/about"
    MENUBAR_ICON_THOMAS_MYLONAS_IMAGE("ThomasMylonas", ".jpg", "Thomas Mylonas", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),

    // "images/menubar_icons"
    MENUBAR_ICON_HOME_IMAGE("Home", ".png", "Home", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR),
    MENUBAR_ICON_LOGOUT_IMAGE("Logout", ".png", "Logout", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR),

    // Empty Value
    EMPTY_VALUE("", "", "", "");

    static final String MAIN_IMAGES_DIR = "images/";
    static final String MAIN_IMAGES_ABOUT_DIR = "about/";
    static final String MAIN_IMAGES_BACKGROUNDS_DIR = "backgrounds/";
    static final String MAIN_IMAGES_JAVA_FRAMEWORKS_DIR = "java_frameworks/";
    static final String MAIN_IMAGES_NAVIGATION_BTNS_DIR = "navigation_btns/";
    static final String MAIN_IMAGES_SOCIAL_MEDIA_DIR = "social_media/";
    static final String MAIN_IMAGES_LANGS_DIR = "langs/";
    static final String MAIN_IMAGES_MENUBAR_ICON_DIR = "menubar_icons/";

    final String imageName;
    final String imageExtension;
    final String imageDescription;
    final String imagePath;

    ImagesEnum(String imageName, String imageExtension, String imageDescription, String imagePath) {
        this.imageName = imageName;
        this.imageExtension = imageExtension;
        this.imageDescription = imageDescription;
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    @SuppressWarnings("unused")
    public String getImageExtension() {
        return imageExtension;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    @SuppressWarnings("unused")
    public String getImagePath() {
        return imagePath;
    }

    public String getImageFullName() {
        return imageName + imageExtension;
    }

    public String getImageFullNameWithPath() {
        return imagePath.endsWith("/") ? imagePath + getImageFullName() : imagePath + "/" + getImageFullName();
    }

    public static String getImageExtensionForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? "" : getImagesEnumForName(imageName).imageExtension;
    }

    public static String getImageDescriptionForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? "" : getImagesEnumForName(imageName).imageDescription;
    }

    public static String getImageFullNameForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? "" : imageName + getImageExtensionForName(imageName);
    }

    public static ImagesEnum getImagesEnumForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? ImagesEnum.EMPTY_VALUE :
                Arrays.stream(ImagesEnum.values()).filter(image -> image.imageName.equals(imageName)).findAny().orElse(ImagesEnum.EMPTY_VALUE);
    }
}
