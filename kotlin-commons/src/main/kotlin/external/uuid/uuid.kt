@file:JsModule("uuid")
@file:JsNonModule
@file:Suppress(
	"INTERFACE_WITH_SUPERCLASS",
	"OVERRIDING_FINAL_MEMBER",
	"RETURN_TYPE_MISMATCH_ON_OVERRIDE",
	"CONFLICTING_OVERLOADS",
	"EXTERNAL_DELEGATION"
)

package external.uuid

@JsName("v4")
external fun uuidV4(): String

external fun validate(uuid: String): Boolean
