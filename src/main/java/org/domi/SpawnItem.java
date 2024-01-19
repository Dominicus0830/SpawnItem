package org.domi;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.domi.commands.Commands;
import org.domi.events.Event;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class SpawnItem extends JavaPlugin {
    private static SpawnItem plugin;

    public static SpawnItem getInstance() {
        return plugin;
    }

    @Override
    //플러그인이 활성화 되었을때
    public void onEnable() {
        plugin = this;

        //이벤트 등록
        new Event();

        //명령어 등록
        new Commands();
    }
}