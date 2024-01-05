package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist.SelectListItem;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface ChannelListControllerFun {
    List<SelectListItem> change();
}
