package org.hiedacamellia.crazyelytra.core.aerodynamics;

import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.Vec3;

public class Aerodynamics {

    public double getAirDensity(double y){
        double rho0=1.225,T0=288.15;
        double rho;
        if(y<=11000){
            double T=T0-0.0065*y;
            rho=rho0*Math.pow(T/T0,4.25588);
        }else if(y>11000&&y<=20000){
            double T=216.65;
            rho=0.36392*Math.exp((-y+11000)/6341.62);
        }else{
            double T=216.65+0.001*(y-20000);
            rho=0.088035*Math.pow(T/216.65,-35.1632);
        }
        return rho;
    }

    public double getAirResistance(double v,double S,double Cd,double rho){
        return 0.5*rho*v*v*S*Cd;
    }

    public double getAirResistanceWithHeight(double v,double S,double Cd,double y){
        return 0.5*v*v*S*Cd*getAirDensity(y);
    }

    public double getAirResistanceWithHeight(double v,double S,double y){
        return getAirResistanceWithHeight(v,S,0.4,y);
    }

    public double getAirResistanceWithHeight(double v,double y){
        return getAirResistanceWithHeight(v,0.1875,getAirDensity(y));
    }

    public double getAirResistanceWithHeight(Vec3 v, double y){
        double v1=Math.sqrt(v.x*v.x+v.y*v.y+v.z*v.z);
        return getAirResistanceWithHeight(v1,y);
    }

    public double getEk(double mass,double v){
        return 0.5*mass*v*v;
    }

    public double getMomentum(double mass,double v){
        return mass*v;
    }

    public double getEp(double mass,double y,Entity entity){
        return mass*getGravitationalAcceleration(entity)*y;
    }

    public double getGravitationalAcceleration(Level level){
        return getGravitationalAcceleration(level.dimension());
    }

    public double getGravitationalAcceleration(ResourceKey<Level> dimension){
        return getGravitationalAcceleration(dimension.location());
    }

    public double getGravitationalAcceleration(ResourceLocation location){
        return getGravitationalAcceleration(location.toString());
    }

    public double getGravitationalAcceleration(String location){
        return switch (location) {
            case "minecraft:overworld" -> 9.8;
            case "minecraft:the_nether" -> 9.8;
            case "minecraft:the_end" -> 9.8;
            default -> 9.8;
        };
    }

}
