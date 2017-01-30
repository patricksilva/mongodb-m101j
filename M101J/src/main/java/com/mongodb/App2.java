package com.mongodb;

import org.bson.BsonDocument;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App2 {

	public static void main(final String[] args) {
		
		// Criar uma conexão com o MongoDB
		/*
		 * MongoClient é um objeto pesado que contém um pool de sockets, ou conexões,
		 * à todos os servidores aos quais você está conectando.
		 * No caso de um "standalone" (localhost), isso seria um servidor sozinho.
		 * Ao utilizar as configurações/opções padrão, temos um objeto capaz de manipular 100
		 * conexões. Por isso é importante certificar-se de não criar instâncias do "MongoClient"
		 * além do mínimo necessário.
		 * Por isso é típico armazenar esse objeto em uma variável "static" para aplicações simples
		 * ou uma variável de instância, se você tiver algum tipo de classe "singleton".
		 * Ou você pode querer configurá-la em um container IOC, como Spring ou Guice(Juice?).
		 * 
		 * 
		 * */
		/*
		// Diferentes maneiras de fazer a mesma coisa, "conectar à instância local na porta padrão":
		final MongoClient client = new MongoClient();
		final MongoClient client = new MongoClient("localhost", 27017);
		final MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		*/
		final MongoClient client = new MongoClient();
		
		/*
		// Para conectar a um cluster de shards MongoDB:
		MongoClient client = new MongoClient(asList(new ServerAddress("localhost", 27017)));
		*/
		/*
		// Também podemos usar uma String de conexão:
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"); 
		*/
		
		
		/*
		// Existem as opções:
		MongoClientOptions options = MongoClientOptions.builder(
			// quando for realizar "deployment", ver quais opções queremos configurar.
		).build();
		
		// Um exemplo comum de se alterar é conexões por host:
		 * 
		MongoClientOptions options = MongoClientOptions.builder()
		.connectionsPerHost(500).build();
		MongoClient client = new MongoClient(new ServerAddress(), options);
		*/
		
		
		// Métodos mais comuns:
		/*
		 * Instâncias do objeto MongoDatabase são leves,
		 * em contraste às instâncias do objeto MongoClient que são pesados.
		 * Elas não precisam ser "cacheadas".
		 * As instâncias de MongoDatabase são imutáveis.
		 * Uma vez uma instância criada, ela não pode ser reconfigurada.
		 * É preciso criar outra nova com a configuração desejada.
		 * 
		 * */
		final MongoDatabase db = client.getDatabase("video");
		
		// exemplo de alteração de configuração
		final MongoDatabase dbConfigured = client.getDatabase("video").withReadPreference(ReadPreference.secondary());
		
		/*
		 * O único cuidado a ser tomado é, uma vez que instâncias da classe "MongoDatabase"
		 * são imutáveis, é preciso certificar-se de salvar os resultados de
		 * "withReadPreference" ou "withWriteConcern" de volta à uma instância do "MongoDatabase".
		 * Isso porque, como ele retorna uma nova instância, se você fizer algo como o exemplo abaixo,
		 * uma nova instância do "MongoDatabase" será criada, mas será perdida, pois não foi armazenada.
		 * */
		// final MongoDatabase db = client.getDatabase("video");
		// db.withReadPreference(ReadPreference.secondary());
		
		/*
		 * "MongoCollection" é o gateway para todas as operações CRUD.
		 * "MongoCollection" são leves e imutáveis.
		 * Se quiser reconfigurá-las, novas instâncias podem ser criadas usando os métodos "with..."
		 * Exemplo: coll = db.getCollection("movies").withWriteConcern(arg0)
		 * 
		 * Mongo shell> use video
		 * MongoDB Java Driver> db   = client.getDatabase("video")
		 * MongoDB Java Driver> coll = db.getCollection("movies")
		 * MongoDB Java Driver> 
		 * 
		 * */
		final MongoCollection coll = db.getCollection("movies");

		/*
		 * "MongoCollection" é de fato uma interface genérica.
		 * Por isso, o método "getCollection" retorna uma instância
		 * da classe "MongoCollection"<Document>,
		 * que é uma forma de representar documentos BSON no driver Java.
		 * 
		 * Motivo: podemos decidir que Document não seja a classe que
		 * queiramos usar para representar os documentos BSON.
		 * O driver Java é disponibilizado com diferentes classes que podemos usar.
		 * 
		 * É semelhante à document, mas é "Type Safe".
		 * */
		final MongoCollection<BsonDocument> collPolymophed = db.getCollection("movies", BsonDocument.class);

		
		
		
		
		
		client.close();
		
	}

}
