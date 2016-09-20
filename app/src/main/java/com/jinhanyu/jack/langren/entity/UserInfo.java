package com.jinhanyu.jack.langren.entity;

import com.jinhanyu.jack.langren.R;
import com.parse.ParseFile;
import com.parse.ParseUser;

/**
 * Created by anzhuo on 2016/9/10.
 */
public class UserInfo {
private String head ="res://com.jinhanyu.jack.langren/"+ R.mipmap.ic_launcher;
    private String name;
    private String userId;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private int vote_police;
    private int vote_kill;
    private int vote_wolf;
    private int score;
    private Type type;



    public void populateFromParseServer(ParseUser parseUser){
        setUserId(parseUser.getObjectId());
        ParseFile file = (ParseFile) parseUser.get("head");
        if(file!=null)
           setHead(file.getUrl());
        setName(parseUser.getUsername());
        setScore((Integer) parseUser.get("score"));
        setTitle((String) parseUser.get("title"));
        setNickname((String) parseUser.get("nickname"));
    }

    public static void reset(UserInfo userInfo){
        userInfo = new UserInfo();
    }

    public Type getType() {
        return type;
    }

    public void setType(int type) {
        this.type = Type.values()[type];
    }

    private int sign_type;
    private boolean isDead;
    private boolean isSpeaking;
    private boolean isReady;
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isSpeaking() {
        return isSpeaking;
    }

    public void setSpeaking(boolean speaking) {
        isSpeaking = speaking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSign_type() {
        return sign_type;
    }

    public void setSign_type(int sign_type) {
        this.sign_type = sign_type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getVote_kill() {
        return vote_kill;
    }

    public void setVote_kill(int vote_kill) {
        this.vote_kill = vote_kill;
    }

    public int getVote_police() {
        return vote_police;
    }

    public void setVote_police(int vote_police) {
        this.vote_police = vote_police;
    }

    public int getVote_wolf() {
        return vote_wolf;
    }

    public void setVote_wolf(int vote_wolf) {
        this.vote_wolf = vote_wolf;
    }


    public enum Type{
         Citizen("村民"),Wolf("狼人"),Predictor("预言家"),Wizard("女巫"),Guard("守卫"),Hunter("猎人");

         Type(String name){
             this.name = name;
         }

        private String name;

        public String getName(){
            return name;
        }


    }
}
