package com.port.actor.player.items;


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

import com.port.actor.Item;
import com.port.actor.npc.hostile.Droid;
import com.port.actor.npc.hostile.Goblin;
import com.port.actor.npc.hostile.Inamic;
import com.port.actor.npc.hostile.SchrodingersCat;
import com.port.actor.player.Player;
import com.port.display.GifImage;
import com.port.world.WorldData;

public class BlackHole extends Item {
 private final long constantEraseTime = 600;int time=0;
    

    GifImage gif = new GifImage("item/blackHole.gif");

    public BlackHole() {
        setImage(gif.getCurrentImage());
    }
 
    public void suck() {
        List npcs = getObjectsInRange(1000, Inamic.class);
        for (Object in : npcs) {
            Inamic inamic = (Inamic) in;
            if (!(inamic instanceof SchrodingersCat)) {
                if ((inamic instanceof Droid) || (inamic instanceof Goblin)) {
                    inamic.turnTowards(this.getX(), this.getY());
                    inamic.move(10);
                }
            }
        }

    }
      private void removeBlackHole() {
        List players = getWorld().getObjects(Player.class);
        Player player = (Player) players.get(0);
        if (!player.isEquipBlackHole()) {
            getWorld().removeObject(this);
            player.setEquipBlackHole(false);
        }
        time++;
            if (time > constantEraseTime) {
                getWorld().removeObject(this);
                player.setEquipBlackHole(false);
            }
    }
    public void act() {

        if (!WorldData.PAUZA) {
           
            suck();
            
            setImage(gif.getCurrentImage()); 
            removeBlackHole();
        }

    }
}