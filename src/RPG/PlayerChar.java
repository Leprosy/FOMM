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
public class PlayerChar {
    public String name;
    public byte clss;
    public byte race;

    public byte hp;
    public byte sp;
    
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
    public byte exp;
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


    public PlayerChar(String name, byte clss, byte race) {
        /* Who is this guy? (i.e. Edward, the gnome robber) */
        this.name = name;
        this.race = race;
        this.clss = clss;

        /* Experience */
        this.att   = 1;
        this.level = 1;
        this.exp   = 0;

        /* Baggage of items, skills and awards */
        this.awards = new ArrayList();
        this.items = new Item[20];

        for (int i = 0; i < 20; ++i) {
            this.items[i] = new Item();
        }

        this.skillList = new boolean[17];

        for (int i = 0;i < 17; ++i) {
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

        /* HP, bonuses & stuff relative to class and race */
        switch(this.clss) {
            case PlayerChar.KNIGHT:
                this.hp = 10;
                this.skillList[PlayerChar.ARMS_MASTER] = true;
                break;
            case PlayerChar.PALADIN:
                this.sp = (byte)(3 + this.bonus(this.per));
                this.skillList[PlayerChar.CRUSADER] = true;
                this.hp = 8;
                break;
            case PlayerChar.ARCHER:
                this.sp = (byte)(3 + this.bonus(this.wis));
                this.hp = 7;
                break;
            case PlayerChar.CLERIC:
                this.sp = (byte)(3 + this.bonus(this.per));
                this.hp = 5;
                break;
            case PlayerChar.SORCERER:
                this.sp = (byte)(3 + this.bonus(this.wis));
                this.skillList[PlayerChar.CARTOGRAPHER] = true;
                this.hp = 4;
                break;
            case PlayerChar.ROBBER:
                this.skillList[PlayerChar.THIEVERY] = true;
                this.hp = 8;
                break;
            case PlayerChar.NINJA:
                this.skillList[PlayerChar.THIEVERY] = true;
                this.hp = 7;
                break;
            case PlayerChar.BARBARIAN:
                this.hp = 12;
                break;
            case PlayerChar.DRUID:
                this.sp = (byte)(3 + (int)((this.bonus(this.wis) + this.bonus(this.per)) / 2));
                this.skillList[PlayerChar.DIRECTION_SENSE] = true;
                this.hp = 6;
                break;
            case PlayerChar.RANGER:
                this.sp = (byte)(3 + (int)((this.bonus(this.wis) + this.bonus(this.per)) / 2));
                this.skillList[PlayerChar.PATHFINDER] = true;
                this.hp = 9;
                break;

            default:
                break;
        }

        switch(this.race) {
            case PlayerChar.HUMAN:
                this.skillList[PlayerChar.SWIMMING] = true;
                this.res_acid = 7;
                this.res_fire = 7;
                this.res_ener = 7;
                this.res_magic = 7;
                this.res_elec = 7;
                this.res_cold = 7;
                break;
            case PlayerChar.ELF:
                this.sp += 2;
                this.hp -= 2;
                this.res_ener = 5;
                this.res_magic = 5;
                break;
            case PlayerChar.DWARF:
                this.sp -= 1;
                this.hp += 1;
                this.skillList[PlayerChar.SPOT_SECRET_DOORS] = true;
                this.res_acid = 20;
                this.res_fire = 5;
                this.res_ener = 5;
                this.res_elec = 5;
                this.res_cold = 5;
                break;
            case PlayerChar.GNOME:
                this.sp += 1;
                this.hp -= 1;
                this.skillList[PlayerChar.DANGER_SENSE] = true;
                this.res_acid = 2;
                this.res_fire = 2;
                this.res_ener = 2;
                this.res_magic = 20;
                this.res_elec = 2;
                this.res_cold = 2;
                break;
            case PlayerChar.HALF_ORC:
                this.sp -= 2;
                this.hp += 2;
                this.res_fire = 10;
                this.res_elec = 10;
                this.res_cold = 10;
                break;

            default:
                break;
        }

        /* Adjustments */
        this.hp += (byte)this.bonus(this.end);
        
        if (this.clss == PlayerChar.PALADIN || this.clss == PlayerChar.RANGER ||
                this.clss == PlayerChar.ARCHER) {
            this.sp = (byte)(this.sp / 2);
        }
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
}
