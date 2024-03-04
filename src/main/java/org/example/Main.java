package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static String retornaListaDaURI(String minhaUri) throws Exception{
        // Puxando o arquivo de texto usando HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String lista = response.body();
        return lista;
    }

    public static String retornaIndiceAleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];





    }

    public static void main(String[] args) throws Exception {
        String listaDeNomes = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        String nome = retornaIndiceAleatorio(listaDeNomes);

        String listaDeSobrenomes = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);

        String listaDePosicoes = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        String posicoes = retornaIndiceAleatorio(listaDePosicoes);

        String listaDeClubes = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
        String Clubes = retornaIndiceAleatorio(listaDeClubes);

        int idade = geranumeroaleatorio(17, 40);

        System.out.println(nome + " " + sobrenome + " é um futebolista de " + idade + " anos que atua como " + posicoes + " atualmente defende o " + Clubes + "." );

    }

public static int geranumeroaleatorio(int menor, int maior){
    int diferenca = maior - menor + 1;
    int aleatorio = (int) Math.floor(Math.random() * diferenca);
    int numero = aleatorio + menor;
    return numero;

}}