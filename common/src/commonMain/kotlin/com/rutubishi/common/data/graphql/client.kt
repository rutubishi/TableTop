import com.apollographql.apollo3.ApolloClient

object GraphQLClient {
    val client = ApolloClient
        .Builder()
        .serverUrl("http://localhost:3000/graphql")
        .build()
}