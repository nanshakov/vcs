package com.nanshakov.vcs2.controllers;//package com.nanshakov.vcs.controllers;
//
//import com.vk.api.sdk.client.TransportClient;
//import com.vk.api.sdk.client.VkApiClient;
//import com.vk.api.sdk.client.actors.UserActor;
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//import com.vk.api.sdk.httpclient.HttpTransportClient;
//import com.vk.api.sdk.objects.users.Fields;
//import common.cache.DialogCache;
//import common.dto.SimpleDialogDto;
//import common.dto.SimpleUserDto;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//import java.security.SecureRandom;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static java.util.stream.Collectors.toList;
//
//@Controller
//public class DialogsController {
//    private static final String AUTHURL = "https://oauth.vk.com/authorize?"
//            + "client_id=2274003&"
//            + "display=page&"
//            + "redirect_uri=https://oauth.vk.com/blank.html&"
//            + "scope=messages&"
//            + "response_type=code&"
//            + "v=5.80";
//
//    @GetMapping("/")
//    public static String getDialogs(Model model, HttpServletResponse response)
//            throws ClientException, ApiException {
//        TransportClient transportClient = new HttpTransportClient();
//        VkApiClient vk = new VkApiClient(transportClient);
//        int uid = 186286611;
//        //21863ce7f99e117fef
//        String accessToken = "1f61792baf62a4b00e84ede8d72ab1ce536631658b9a6203ff7a64080e1945340c4d7f74020d5e6a31209";
//        UserActor actor = new UserActor(uid, accessToken);
//        List<SimpleDialogDto> dialogs = vk.messages().getConversations(actor).count(200).execute().getItems().stream()
//                .map(SimpleDialogDto::new)
//                .collect(toList());
//        List<String> uiDs = new ArrayList<>();
//        for (SimpleDialogDto sd : dialogs) {
//            uiDs.add(String.valueOf(sd.userId));
//        }
//
//        Map<Long, String> uidNamePairs = new HashMap<>();
//
//        List<SimpleUserDto> users = vk.users().get(actor)
//                .userIds(uiDs)
//                .fields(Fields.SCREEN_NAME, Fields.PHOTO_100)
//                .execute().stream()
//                .map(SimpleUserDto::new)
//                .collect(toList());
//
//        for (SimpleUserDto u : users) {
//            uidNamePairs.put(u.userId, u.screenName);
//        }
//
//        //secure
//        SecureRandom random = new SecureRandom();
//        byte bytes[] = new byte[256];
//        random.nextBytes(bytes);
//        String gKey = DigestUtils.sha256Hex(bytes);
//        //secure
//
//        for (SimpleDialogDto dialog : dialogs) {
//            DialogCache.getInstance().push(dialog, gKey);
//            dialog.setScreenUserName(uidNamePairs.get(dialog.userId));
//        }
//
//        model.addAttribute("simpleDialog", dialogs);
//        response.addCookie(new Cookie("GKey", gKey));
//        return "getDialogs";
//    }
//}
