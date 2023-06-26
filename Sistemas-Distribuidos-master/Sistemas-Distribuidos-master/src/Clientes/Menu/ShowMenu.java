package Clientes.Menu;

public class ShowMenu {
    private static int maxSize = 40;
    
    /*
        Função principal
    */
    public static void Print(String[] allMessages,String tipInput,String sucessMessage)
    {
        StringBuilder sb = new StringBuilder();

        PrintMenu(sb,allMessages);

        System.out.println(sb.toString());

        System.out.print(sucessMessage);
        
        System.out.print(tipInput);

    }
    private static void PrintMenu(StringBuilder sb,String[] allMessages)
    {
        int length = allMessages.length;
        if (length == 0) return;

        DrawTop(sb);
        for (int i = 0; i < length; i++) {
            DrawMessage(sb,allMessages[i]);
        }
        DrawTop(sb);
    }

    private static void DrawTop(StringBuilder sb) {
        sb.append("|");
        for (int i = 0; i < maxSize; i++) {
            sb.append("-");
        }
        sb.append("|\n");
    }

    private static void DrawMessage(StringBuilder sb,String message) {
        int offset = (maxSize - message.length()) / 2;
        sb.append("|");
        for (int i = 0; i < offset; i++) {
            sb.append(" ");
        }
        sb.append(message);
        for (int i = 0; i < offset; i++) {
            sb.append(" ");
        }
        if (message.length() % 2 == 1) sb.append(" ");
        sb.append("|\n");
    }
    public static void ClearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
