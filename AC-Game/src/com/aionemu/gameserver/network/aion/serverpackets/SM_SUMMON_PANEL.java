/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, ragarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 

 * @-Aion-Lightning
 * @Goong_ADM

 

 */
package com.aionemu.gameserver.network.aion.serverpackets;

import com.aionemu.gameserver.model.gameobjects.Summon;
import com.aionemu.gameserver.network.PacketLoggerService;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;

/**
 * @author ATracer, xTz
 */
public class SM_SUMMON_PANEL extends AionServerPacket {

    private Summon summon;

    public SM_SUMMON_PANEL(Summon summon) {
        this.summon = summon;
    }

    @Override
    protected void writeImpl(AionConnection con) {
    	PacketLoggerService.getInstance().logPacketSM(this.getPacketName());
        writeD(summon.getObjectId());
        writeH(summon.getLevel());
        writeD(0);// unk
        writeD(0);// unk
        writeD(summon.getLifeStats().getCurrentHp());
        writeD(summon.getGameStats().getMaxHp().getCurrent());
        writeD(summon.getGameStats().getMainHandPAttack().getCurrent());
        writeH(summon.getGameStats().getPDef().getCurrent());
        writeH(0);
        writeH(summon.getGameStats().getMResist().getCurrent());
        writeH(0);// unk
        writeH(0);// unk
        writeD(summon.getLiveTime()); // life time
    }
}