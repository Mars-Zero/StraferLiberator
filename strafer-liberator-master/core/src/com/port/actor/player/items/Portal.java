package com.port.actor.player.items;


import greenfoot.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.port.actor.player.Player;
import com.port.display.Effect;
import com.port.display.GifImage;
import com.port.utils.Scroller;
import com.port.world.WorldData;

public class Portal extends PortalGun {

    HashMap<String, GifImage> directie = new HashMap<String, GifImage>();

    GifImage portalImg;
    private long time = 0;
    public Portal() {

        directie.put("A", new GifImage("item/portalA.gif"));
        directie.put("D", new GifImage("item/portalD.gif"));

        if (Greenfoot.getRandomNumber(12) % 2 == 0) {
            portalImg = directie.get("D");
        } else {
            portalImg = directie.get("A");
        }

        this.time = 0;

    }

    public void teleport() {
        List players = getWorld().getObjects(Player.class);

        if (!players.isEmpty()) {
            Player player = (Player) players.get(0);
            if (Greenfoot.isKeyDown("T")) {

                getWorld().addObject(new Effect("kingcrimson", 62, 1), 0, 0);
                
                player.setWorldX((int) (player.getWorldX()+(this.getX() + Scroller.scrolledX - player.getX())));
                player.setWorldY((int) (player.getWorldY()+(this.getY() + Scroller.scrolledY - player.getY())));
                
                player.setLocation(this.getX(), this.getY());
                
                getWorld().removeObject(this);
            }

        }

    }

    public void act() {

        if (!WorldData.PAUZA) {
            teleport();
        }
        setImage(portalImg.getCurrentImage());

    }
}