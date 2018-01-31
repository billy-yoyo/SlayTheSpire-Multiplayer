package com.megacrit.cardcrawl.screens.mainMenu;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.billyoyo.cardcrawl.multiplayer.client.StaticRoomLauncher;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.GameCursor;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.daily.DailyMods;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.InputHelper;
import com.megacrit.cardcrawl.helpers.MathHelper;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.screens.saveAndContinue.SaveAndContinue;
import com.megacrit.cardcrawl.screens.saveAndContinue.SaveFile;
import com.megacrit.cardcrawl.screens.stats.StatsScreen;

public class MenuButton {
    private static final UIStrings uiStrings;
    public static final String[] TEXT;
    public ClickResult result;
    private String label;
    private Hitbox hb;
    private Color tint;
    private int index;
    private boolean isDisabled;
    private float x;
    private float targetX;
    public static final float FONT_X;
    public static final float START_Y;
    public static final float SPACE_Y;
    public static final float FONT_OFFSET_Y;
    private boolean confirmation;

    public MenuButton(ClickResult r, int index) {
        this.tint = Color.WHITE.cpy();
        this.isDisabled = false;
        this.x = 0.0F;
        this.targetX = 0.0F;
        this.confirmation = false;
        this.result = r;
        this.index = index;
        this.setLabel();
        this.hb = new Hitbox(FontHelper.getSmartWidth(FontHelper.buttonLabelFont, this.label, 9999.0F, 1.0F) + 100.0F * Settings.scale, SPACE_Y);
        this.hb.move(this.hb.width / 2.0F + 75.0F * Settings.scale, START_Y + (float)index * SPACE_Y);
    }

    private void setLabel() {
        switch(result) {
            case CARDS:
                this.label = TEXT[0];
                break;
            case CHAR_SELECT:
                this.label = TEXT[1];
                break;
            case DAILY:
                this.label = TEXT[2];
                break;
            case RELICS:
                this.label = TEXT[3];
                break;
            case RESUME_GAME:
                this.label = TEXT[4];
                break;
            case LEADERBOARD:
                this.label = TEXT[5];
                break;
            case STATS:
                this.label = TEXT[6];
                break;
            case RUN_HISTORY:
                this.label = TEXT[13];
                break;
            case CREDITS:
                this.label = TEXT[7];
                break;
            case SETTINGS:
                this.label = TEXT[12];
                break;
            case QUIT:
                this.label = TEXT[8];
                break;
            case PATCH_NOTES:
                this.label = TEXT[9];
                break;
            case ABANDON_RUN:
                this.label = TEXT[10];
                break;
            case MULTIPLAYER:
                this.label = "Multiplayer";
                break;
            default:
                this.label = "ERROR";
        }

    }

    public void update() {
        if(CardCrawlGame.mainMenuScreen.screen == MainMenuScreen.CurScreen.MAIN_MENU && CardCrawlGame.mainMenuScreen.bg.slider < 0.5F) {
            this.hb.update();
        }

        this.x = MathHelper.uiLerpSnap(this.x, this.targetX);
        if(this.hb.justHovered) {
            CardCrawlGame.sound.playV("UI_HOVER", 0.75F);
        }

        if(this.hb.hovered) {
            this.targetX = 25.0F * Settings.scale;
            if(InputHelper.justClickedLeft) {
                CardCrawlGame.sound.playA("UI_CLICK_1", -0.1F);
                this.hb.clickStarted = true;
            }

            this.tint = Color.WHITE.cpy();
        } else if(CardCrawlGame.mainMenuScreen.screen == MainMenuScreen.CurScreen.MAIN_MENU) {
            this.targetX = 0.0F;
            this.tint.r = MathHelper.fadeLerpSnap(this.tint.r, 0.3F);
            this.tint.g = this.tint.r;
            this.tint.b = this.tint.r;
        }

        if(this.hb.clicked) {
            this.hb.clicked = false;
            this.buttonEffect();
            CardCrawlGame.mainMenuScreen.hideMenuButtons();
        }

    }

    public void hide() {
        this.hb.hovered = false;
        this.targetX = -1000.0F * Settings.scale + 30.0F * Settings.scale * (float)this.index;
    }

    public void buttonEffect() {
        switch(result) {
            case CARDS:
                CardCrawlGame.mainMenuScreen.cardLibraryScreen.open();
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.CARD_LIBRARY;
                break;
            case CHAR_SELECT:
                CardCrawlGame.mainMenuScreen.charSelectScreen.open();
            case DAILY:
            default:
                break;
            case RELICS:
                CardCrawlGame.mainMenuScreen.relicScreen.open();
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.RELIC_VIEW;
                break;
            case RESUME_GAME:
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.NONE;
                CardCrawlGame.mainMenuScreen.hideMenuButtons();
                CardCrawlGame.mainMenuScreen.darken();
                this.resumeGame();
                break;
            case LEADERBOARD:
                CardCrawlGame.mainMenuScreen.leaderboardsScreen.open();
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.LEADERBOARD;
                break;
            case STATS:
                CardCrawlGame.mainMenuScreen.statsScreen.open();
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.STATS;
                break;
            case RUN_HISTORY:
                CardCrawlGame.mainMenuScreen.runHistoryScreen.open();
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.RUN_HISTORY;
                break;
            case CREDITS:
                CardCrawlGame.mainMenuScreen.creditsScreen.open();
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.CREDITS;
                break;
            case SETTINGS:
                GameCursor.hidden = false;
                CardCrawlGame.sound.play("END_TURN");
                CardCrawlGame.mainMenuScreen.isSettingsUp = true;
                InputHelper.pressedEscape = false;
                CardCrawlGame.mainMenuScreen.lighten();
                CardCrawlGame.mainMenuScreen.statsScreen.hide();
                CardCrawlGame.mainMenuScreen.cancelButton.hide();
                CardCrawlGame.cancelButton.show(MainMenuScreen.TEXT[2]);
                CardCrawlGame.mainMenuScreen.screen = MainMenuScreen.CurScreen.SETTINGS;
                break;
            case QUIT:
                Gdx.app.exit();
                break;
            case PATCH_NOTES:
                CardCrawlGame.mainMenuScreen.patchNotesScreen.open();
                break;
            case ABANDON_RUN:
                if(!this.confirmation) {
                    this.confirmation = true;
                } else {
                    if(SaveAndContinue.ironcladSaveExists) {
                        SaveAndContinue.ironcladSaveExists = false;
                        this.abandonRun(AbstractPlayer.PlayerClass.IRONCLAD);
                    } else if(SaveAndContinue.silentSaveExists) {
                        SaveAndContinue.silentSaveExists = false;
                        this.abandonRun(AbstractPlayer.PlayerClass.THE_SILENT);
                    } else if(SaveAndContinue.crowbotSaveExists) {
                        SaveAndContinue.crowbotSaveExists = false;
                        this.abandonRun(AbstractPlayer.PlayerClass.CROWBOT);
                    }

                    CardCrawlGame.mainMenuScreen.abandonedRun = true;
                }
                break;
            case MULTIPLAYER:
                StaticRoomLauncher.launchRoom();
                break;
        }

    }

    private void abandonRun(AbstractPlayer.PlayerClass pClass) {
        SaveFile file = SaveAndContinue.loadSaveFile(pClass);
        if(file.floor_num >= 16) {
            CardCrawlGame.playerPref.putInteger(pClass.name() + "_SPIRITS", 1);
            CardCrawlGame.playerPref.flush();
        } else {
            CardCrawlGame.playerPref.putInteger(pClass.name() + "_SPIRITS", 0);
            CardCrawlGame.playerPref.flush();
        }

        SaveAndContinue.deleteSave(pClass);
        if(!file.is_ascension_mode) {
            StatsScreen.incrementDeath(pClass);
        }

    }

    private void resumeGame() {
        CardCrawlGame.loadingSave = true;
        if(SaveAndContinue.ironcladSaveExists) {
            CardCrawlGame.chosenCharacter = AbstractPlayer.PlayerClass.IRONCLAD;
        } else if(SaveAndContinue.silentSaveExists) {
            CardCrawlGame.chosenCharacter = AbstractPlayer.PlayerClass.THE_SILENT;
        } else if(SaveAndContinue.crowbotSaveExists) {
            CardCrawlGame.chosenCharacter = AbstractPlayer.PlayerClass.CROWBOT;
        }

        CardCrawlGame.mainMenuScreen.isFadingOut = true;
        CardCrawlGame.mainMenuScreen.fadeOutMusic();
        Settings.isDailyRun = false;
        Settings.isTrial = false;
        DailyMods.setModsFalse();
    }

    public void render(SpriteBatch sb) {
        float lerper = Interpolation.circleIn.apply(CardCrawlGame.mainMenuScreen.bg.slider);
        float sliderX = -1000.0F * Settings.scale * lerper;
        sliderX -= (float)this.index * 250.0F * Settings.scale * lerper;
        if(this.result == com.megacrit.cardcrawl.screens.mainMenu.MenuButton.ClickResult.ABANDON_RUN) {
            if(this.confirmation) {
                this.label = TEXT[11];
            } else {
                this.label = TEXT[10];
            }
        }

        if(this.hb.hovered) {
            FontHelper.renderSmartText(sb, FontHelper.buttonLabelFont, this.label, this.x + FONT_X + sliderX, this.hb.cY + FONT_OFFSET_Y, 9999.0F, 1.0F, Settings.GOLD_COLOR);
        } else if(this.isDisabled) {
            FontHelper.renderSmartText(sb, FontHelper.buttonLabelFont, this.label, this.x + FONT_X + sliderX, this.hb.cY + FONT_OFFSET_Y, 9999.0F, 1.0F, Settings.RED_TEXT_COLOR);
        } else {
            FontHelper.renderSmartText(sb, FontHelper.buttonLabelFont, this.label, this.x + FONT_X + sliderX, this.hb.cY + FONT_OFFSET_Y, 9999.0F, 1.0F, Settings.CREAM_COLOR);
        }

        this.hb.render(sb);
    }

    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("MenuButton");
        TEXT = uiStrings.TEXT;
        FONT_X = 120.0F * Settings.scale;
        START_Y = 120.0F * Settings.scale;
        SPACE_Y = 50.0F * Settings.scale;
        FONT_OFFSET_Y = 10.0F * Settings.scale;
    }

    public static enum ClickResult {
        CHAR_SELECT,
        DAILY,
        CARDS,
        RELICS,
        LEADERBOARD,
        STATS,
        RUN_HISTORY,
        CREDITS,
        QUIT,
        RESUME_GAME,
        PATCH_NOTES,
        ABANDON_RUN,
        SETTINGS,
        MULTIPLAYER;

        private ClickResult() {
        }
    }
}
