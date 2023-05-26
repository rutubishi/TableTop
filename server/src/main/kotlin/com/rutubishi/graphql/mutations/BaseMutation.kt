package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder

interface BaseMutation {
    val builder: SchemaBuilder
    fun register(schemaBuilder: SchemaBuilder)
    fun registerTypes()
}

abstract class AbstractMutation: BaseMutation {
    override lateinit var builder: SchemaBuilder
    override fun register(schemaBuilder: SchemaBuilder) {
        builder = schemaBuilder
    }
}
