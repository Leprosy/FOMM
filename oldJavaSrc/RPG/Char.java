/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import java.util.ArrayList;

/**
 *
 * @author mrojas
 */
public class Char {
    public String name;
    public byte clss;
    public byte race;

    public short hp;
    public short sp;
    
    public byte str;
    public byte wis;
    public byte end;
    public byte lck;
    public byte per;
    public byte acc;
    public byte spd;
    public byte age;

    public byte res_fire;
    public byte res_elec;
    public byte res_acid;
    public byte res_cold;
    public byte res_magic;
    public byte res_ener;

    public byte thievery;

    public byte level;
    public int exp;
    public byte att;

    public ArrayList awards;
    public boolean[] skillList;
    public Item[] items;


    /* Me constants */
    public final static byte HUMAN = 0;
    public final static byte ELF = 1;
    public final static byte DWARF = 2;
    public final static byte GNOME = 3;
    public final static byte HALF_ORC = 4;

    public final static String[] races = {
        "Human",
        "Elf",
        "Dwarf",
        "Gnome",
        "Half-Orc"
    };

    public final static byte KNIGHT = 0;
    public final static byte PALADIN = 1;
    public final static byte ARCHER = 2;
    public final static byte CLERIC = 3;
    public final static byte SORCERER = 4;
    public final static byte ROBBER = 5;
    public final static byte NINJA = 6;
    public final static byte BARBARIAN = 7;
    public final static byte DRUID = 8;
    public final static byte RANGER = 9;

    public final static String[] classes = {
        "Knight",
        "Paladin",
        "Archer",
        "Cleric",
        "Sorcerer",
        "Robber",
        "Ninja",
        "Barbarian",
        "Druid",
        "Ranger"
    };

    public final static byte ARMS_MASTER = 0;
    public final static byte ASTROLOGER = 1;
    public final static byte BODY_BUILDER = 2;
    public final static byte CARTOGRAPHER = 3;
    public final static byte CRUSADER = 4;
    public final static byte DANGER_SENSE = 5;
    public final static byte DIRECTION_SENSE = 6;
    public final static byte LINGUIST = 7;
    public final static byte MERCHANT = 8;
    public final static byte MOUNTAINEER = 9;
    public final static byte NAVIGATOR = 10;
    public final static byte PATHFINDER = 11;
    public final static byte PRAYER_MASTER = 12;
    public final static byte PRESTIDIGITATOR = 13;
    public final static byte SPOT_SECRET_DOORS = 14;
    public final static byte SWIMMING = 15;
    public final static byte THIEVERY = 16;

    public final static String[] skill = {
        "Arms Master",
        "Astrologer",
        "Body Builder",
        "Cartographer",
        "Crusader",
        "Danger Sense",
        "Direction Sense",
        "Linguist",
        "Merchant",
        "Mountaineer",
        "Navigator",
        "Pathfinder",
        "Prayer Master",
        "Prestidigitator",
        "Spot Secret Doors",
        "Swimming",
        "Thievery"
    };


    public Char(String name, byte clss, byte race) {
        /* Who is this guy? (i.e. Edward, the gnome robber) */
        this.name = name;
        this.race = race;
        this.clss = clss;

        /* Experience */
        this.att   = 1;
        this.level = 0;
        this.exp   = 0;
        this.sp    = 0;
        this.hp    = 0;

        /* Baggage of items, skills and awards */
        this.awards = new ArrayList();
        this.items = new Item[20];

        for (int i = 0; i < 20; ++i) {
            this.items[i] = new Item();
        }

        this.skillList = new boolean[17];

        for (int i = 0; i < 17; ++i) {
            this.skillList[i] = false;
        }

        /* The stats */
        this.str = (byte)(Math.random() * 10 + 10);
        this.wis = (byte)(Math.random() * 10 + 10);
        this.end = (byte)(Math.random() * 10 + 10);
        this.lck = (byte)(Math.random() * 10 + 10);
        this.per = (byte)(Math.random() * 10 + 10);
        this.acc = (byte)(Math.random() * 10 + 10);
        this.spd = (byte)(Math.random() * 10 + 10);
        this.spd = (byte)(Math.random() * 10 + 10);
        this.age = (byte)(Math.random() * 10 + 18);

        /* Get your first level */
        this.levelUp();
    }

    public short bonus(byte stat) {
        if (stat <= 2) return -5;
        if (3 <= stat && stat <= 4) return -4;
        if (5 <= stat && stat <= 6) return -3;
        if (7 <= stat && stat <= 8) return -2;
        if (9 <= stat && stat <= 10) return -3;
        if (11 <= stat && stat <= 12) return 0;
        if (13 <= stat && stat <= 14) return 1;
        if (15 <= stat && stat <= 16) return 2;
        if (17 <= stat && stat <= 18) return 3;
        if (19 <= stat && stat <= 20) return 4;
        if (21 <= stat && stat <= 24) return 5;
        if (25 <= stat && stat <= 29) return 6;
        if (30 <= stat && stat <= 34) return 7;
        if (35 <= stat && stat <= 39) return 8;
        if (40 <= stat && stat <= 49) return 9;
        if (50 <= stat && stat <= 74) return 10;
        if (75 <= stat && stat <= 99) return 11;
        if (100 <= stat && stat <= 124) return 12;
        if (125 <= stat && stat <= 149) return 13;
        if (150 <= stat && stat <= 174) return 14;
        if (175 <= stat && stat <= 199) return 15;
        if (200 <= stat && stat <= 224) return 16;
        if (225 <= stat && stat <= 249) return 17;
        if (250 <= stat) return 20;

        return 0;
    }

    public String bonusName(byte stat) {
        if (stat <= 2) return "Nonexistant";
        if (3 <= stat && stat <= 4) return "Very Poor";
        if (5 <= stat && stat <= 6) return "Poor";
        if (7 <= stat && stat <= 8) return "Very Low";
        if (9 <= stat && stat <= 10) return "Low";
        if (11 <= stat && stat <= 12) return "Average";
        if (13 <= stat && stat <= 14) return "Good";
        if (15 <= stat && stat <= 16) return "Very Good";
        if (17 <= stat && stat <= 18) return "High";
        if (19 <= stat && stat <= 20) return "Very High";
        if (21 <= stat && stat <= 24) return "Great";
        if (25 <= stat && stat <= 29) return "Super";
        if (30 <= stat && stat <= 34) return "Amazing";
        if (35 <= stat && stat <= 39) return "Incredible";
        if (40 <= stat && stat <= 49) return "Gigantic";
        if (50 <= stat && stat <= 74) return "Fantastic";
        if (75 <= stat && stat <= 99) return "Astounding";
        if (100 <= stat && stat <= 124) return "Astonishing";
        if (125 <= stat && stat <= 149) return "Monumental";
        if (150 <= stat && stat <= 174) return "Tremendous";
        if (175 <= stat && stat <= 199) return "Collosal";
        if (200 <= stat && stat <= 224) return "Awesome";
        if (225 <= stat && stat <= 249) return "Awe Inspiring";
        if (250 <= stat) return "Ultimate";

        return "None";
    }

    public void levelUp() {
        /* We are leveling up XD */
        this.level++;

        /* What's next? Make the character stronger, applying the bonuses and racial mods */
        
        /* Minor spell casters have their sp increment halved :( */
        short dsp = 0;

        /* Class adjustments */
        switch(this.clss) {
            case Char.KNIGHT:
                this.hp += 10;
                this.skillList[Char.ARMS_MASTER] = true;
                
                if (this.level % 5 == 0) {
                    this.att++;
                }
                break;
            case Char.PALADIN:
                this.hp += 8;
                dsp = (byte)(3 + this.bonus(this.per));
                this.skillList[Char.CRUSADER] = true;

                if (this.level % 6 == 0) {
                    this.att++;
                }

                if (this.skillList[Char.PRAYER_MASTER]) {
                    this.sp += 1;
                }
                break;
            case Char.ARCHER:
                dsp = (byte)(3 + this.bonus(this.wis));
                this.hp += 7;

                if (this.level % 6 == 0) {
                    this.att++;
                }

                if (this.skillList[Char.PRESTIDIGITATOR]) {
                    this.sp += 1;
                }
                break;
            case Char.CLERIC:
                this.sp += (byte)(3 + this.bonus(this.per));
                this.hp += 5;

                if (this.level % 7 == 0) {
                    this.att++;
                }

                if (this.skillList[Char.PRAYER_MASTER]) {
                    this.sp += 2;
                }
                break;
            case Char.SORCERER:
                this.sp += (byte)(3 + this.bonus(this.wis));
                this.hp += 4;
                this.skillList[Char.CARTOGRAPHER] = true;

                if (this.level % 8 == 0) {
                    this.att++;
                }

                if (this.skillList[Char.PRESTIDIGITATOR]) {
                    this.sp += 2;
                }
                break;
            case Char.ROBBER:
                this.hp += 8;
                this.skillList[Char.THIEVERY] = true;

                if (this.level % 6 == 0) {
                    this.att++;
                }
                break;
            case Char.NINJA:
                this.hp += 7;
                this.skillList[Char.THIEVERY] = true;

                if (this.level % 5 == 0) {
                    this.att++;
                }
                break;
            case Char.BARBARIAN:
                this.hp += 12;

                if (this.level % 4 == 0) {
                    this.att++;
                }
                break;
            case Char.DRUID:
                this.sp += (byte)(3 + (int)((this.bonus(this.wis) + this.bonus(this.per)) / 2));
                this.hp += 6;
                this.skillList[Char.DIRECTION_SENSE] = true;

                if (this.level % 7 == 0) {
                    this.att++;
                }

                if (this.skillList[Char.ASTROLOGER]) {
                    this.sp += 2;
                }
                break;
            case Char.RANGER:
                dsp = (byte)(3 + (int)((this.bonus(this.wis) + this.bonus(this.per)) / 2));
                this.hp += 9;
                this.skillList[Char.PATHFINDER] = true;

                if (this.level % 6 == 0) {
                    this.att++;
                }

                if (this.skillList[Char.ASTROLOGER]) {
                    this.sp += 1;
                }
                break;

            default:
                break;
        }

        /* Racial adjustments, you racist prick XD */
        switch(this.race) {
            case Char.HUMAN:
                if (this.level == 1) {
                    this.skillList[Char.SWIMMING] = true;
                    this.res_acid = 7;
                    this.res_fire = 7;
                    this.res_ener = 7;
                    this.res_magic = 7;
                    this.res_elec = 7;
                    this.res_cold = 7;
                }
                break;
            case Char.ELF:
                this.hp -= 2;

                if (this.isSpellCaster()) {
                    this.sp += 2;
                }

                if (this.level == 1) {
                    this.res_ener = 5;
                    this.res_magic = 5;
                }
                break;
            case Char.DWARF:
                this.hp += 1;

                if (this.isSpellCaster()) {
                    this.sp -= 1;
                }

                if (this.level == 1) {
                    this.skillList[Char.SPOT_SECRET_DOORS] = true;
                    this.res_acid = 20;
                    this.res_fire = 5;
                    this.res_ener = 5;
                    this.res_elec = 5;
                    this.res_cold = 5;
                }
                break;
            case Char.GNOME:
                this.hp -= 1;
                
                if (this.isSpellCaster()) {
                    this.sp += 1;
                }

                if (this.level == 1) {
                    this.skillList[Char.DANGER_SENSE] = true;
                    this.res_acid = 2;
                    this.res_fire = 2;
                    this.res_ener = 2;
                    this.res_magic = 20;
                    this.res_elec = 2;
                    this.res_cold = 2;
                }
                break;
            case Char.HALF_ORC:
                this.hp += 2;
                
                if (this.isSpellCaster()) {
                    this.sp -= 2;
                }

                if (this.level == 1) {
                    this.res_fire = 10;
                    this.res_elec = 10;
                    this.res_cold = 10;
                }
                break;

            default:
                break;
        }

        /* Adjustments */
        this.hp += (byte)this.bonus(this.end);

        if (this.skillList[Char.BODY_BUILDER]) {
            this.hp += 2;
        }

        /* Minor spellcasters */
        if (dsp > 0) {
            this.sp += (byte)(dsp / 2);
        }
    }

    public boolean isSpellCaster() {
        return (this.clss == Char.SORCERER || 
                this.clss == Char.CLERIC ||
                this.clss == Char.DRUID ||
                this.clss == Char.PALADIN ||
                this.clss == Char.ARCHER ||
                this.clss == Char.RANGER);
    }

    public byte getAC() {
        return (byte)this.bonus(this.spd);
    }

    public byte getDamage() {
        return (byte)this.bonus(this.str);
    }

    public byte getToHit() {
        byte hit = 0;

        if (this.skillList[Char.ARMS_MASTER]) {
            hit = 1;
        }

        return (byte)(hit + this.bonus(this.acc));
    }
}