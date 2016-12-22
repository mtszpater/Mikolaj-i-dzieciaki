package com.company;

/**
 * author @pater
 */
public class Configuration {

    /** SETTINGS **/
    public static final String GAME_TITLE = "Mikołaj i dzieciaki";
    public static final int DELAY = 20;
    public static final int BOARD_SIZE = 12;
    public static final int BOARD_START = 0;
    public static final int WIDTH = 1440;
    public static final int HEIGHT = 760;
    public static final int ICON_SIZE = HEIGHT / BOARD_SIZE;
    public static final int WIDTH_SCALE = WIDTH / BOARD_SIZE;
    public static final int HEIGHT_SCALE = HEIGHT / BOARD_SIZE;

    /** GAME PROPERTIES **/
    public static final int NUMBER_OF_CHILDREN = 2;
    public static final int SANTA_BAG_LIMIT = 2 * NUMBER_OF_CHILDREN;
    
    /** IMAGES **/
    public static final String BACKGROUND = "../../images/background.jpg";
    public static final String SANTA_IMAGE = "../../images/santa.png";
    public static final String KID_IMAGE = "../../images/kid.png";
    public static final String KID_SLEEPING_IMAGE = "../../images/kid-sleeping.png";
    public static final String KID_GROUNDED_IMAGE = "../../images/kid-grounded.png";
    public static final String TOY_1_IMAGE = "../../images/toy_0.png";
    public static final String TOY_2_IMAGE = "../../images/toy_1.png";
    public static final String TOY_3_IMAGE = "../../images/toy_2.png";
    public static final String TOY_4_IMAGE = "../../images/toy_3.png";
    public static final String TOY_5_IMAGE = "../../images/toy_4.png";

    public static final String BACKGROUND_MUSIC = "../../../images/music.wav";
}
