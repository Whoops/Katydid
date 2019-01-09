//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.kotlgen.model.declarations.classes

import o.katydid.kotlgen.model.core.names.KgNamed
import o.katydid.kotlgen.model.types.generics.KgGeneric

//---------------------------------------------------------------------------------------------------------------------

interface KgDataClass
    : KgAbstractStructure, KgNamed, KgGeneric {

    ////

    operator fun invoke(revise: KgDataClass.() -> Unit) =
        this.revise()

}

//---------------------------------------------------------------------------------------------------------------------