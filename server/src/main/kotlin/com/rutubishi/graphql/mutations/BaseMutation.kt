package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.schema.Schema

interface BaseMutation {
    fun register(): Array<() ->Schema>
}