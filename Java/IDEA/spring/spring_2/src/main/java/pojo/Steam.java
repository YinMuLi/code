package pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author 饮木
 * @Date 2022/7/16 13:02
 * @Description: TODO
 */
public class Steam {
    List<Game> games;
    List<String> animations;
    Set<String> roles;
    Map<String,Integer> ages;

    public Steam() {
    }

    public void setAnimations(List<String> animations) {
        this.animations = animations;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setAges(Map<String, Integer> ages) {
        this.ages = ages;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Steam{" +
                "games=" + games +
                ", animations=" + animations +
                ", roles=" + roles +
                ", ages=" + ages +
                '}';
    }
}
