package Servidores.Dados;


import Viagens.Cidade;

public class ServerData {

    Users allUsers = new Users();
    GrafoCidades grafoCidades = new GrafoCidades();
    Reservas allReservas = new Reservas();
    
    DiasEncerrados allDiasEncerrados = new DiasEncerrados();
   

    public ServerData()
    {
        AddCities();
        AddUsers();
    }

    private void AddUsers() {
        allUsers.addUser("andre","123", false);
        allUsers.addUser("rui","123", true);
    }


    private void AddCities() {
        Cidade c1 = new Cidade("Braga");
        Cidade c2 = new Cidade("Porto");
        Cidade c3 = new Cidade("Madrid");
        Cidade c4 = new Cidade("California");
        Cidade c5 = new Cidade("Pyongyang");
        Cidade c6 = new Cidade("Beijing");
        Cidade c7 = new Cidade("Nevada");
        Cidade c8 = new Cidade("Turim");
        Cidade c9 = new Cidade("Veneza");
        
        grafoCidades.addCidade(c1);
        grafoCidades.addCidade(c2);
        grafoCidades.addCidade(c3);
        grafoCidades.addCidade(c4);
        grafoCidades.addCidade(c5);
        grafoCidades.addCidade(c6);
        grafoCidades.addCidade(c7);
        grafoCidades.addCidade(c8);
        grafoCidades.addCidade(c9);

        grafoCidades.addVoo(c1,c2,2);
        grafoCidades.addVoo(c1,c3,2);
        grafoCidades.addVoo(c3,c4,2);
        grafoCidades.addVoo(c8,c9,2);
        grafoCidades.addVoo(c8,c4,2);
        grafoCidades.addVoo(c5,c6,2);
        grafoCidades.addVoo(c4,c6,2);
        grafoCidades.addVoo(c8,c7,2);
        grafoCidades.addVoo(c1,c9,503);

    }

    /*

            **GETTERS**
    
    */
    public DiasEncerrados GetDiasEncerrados()
    {
        return allDiasEncerrados;
    }
    public Users GetUsers()
    {
        return allUsers;
    }
    public Reservas GetReservas()
    {
        return allReservas;
    }
    public GrafoCidades GetGrafoCidades()
    {
        return grafoCidades;
    }
   
}
    

