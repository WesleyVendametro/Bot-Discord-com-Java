import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.Random;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDABuilder.createDefault("// token do bot disponivel no discord")
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new Main())
                .build();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.equals("!imagem")) {
            event.getChannel().sendMessage("Aprecie sua obra de arte").queue();

            String imagemAleatoria = obterImagemAleatoria();
            event.getChannel().sendMessage(imagemAleatoria).queue();
        }
    }
    private String obterImagemAleatoria() {
        String[] linksDeImagens = {
                "Coloque o Link",
        };
        Random random = new Random();
        int indiceAleatorio = random.nextInt(linksDeImagens.length);
        return linksDeImagens[indiceAleatorio];
    }
}












