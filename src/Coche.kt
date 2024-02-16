abstract class Coche(kmHora: Int, estado: String) : Vehiculo, EncendidoApagado {

    override var kmHora: Int = kmHora
        set(value) {
            obtenerKmHora()
            field = value
        }
    override var estado: EncendidoApagado = estado
        set(value) {
            obtenerEstado(value)
            field = value
        }

    override fun encender() {
        estadoMotor = EncendidoApagado.ENCENDIDO
    }

    override fun apagar() {
        estadoMotor = EncendidoApagado.APAGADO
    }
    open fun obtenerEstado(estado: EncendidoApagado) {
        require(estado == EncendidoApagado.APAGADO || estado is EncendidoApagado.ENCENDIDO) { "Sólo puede estar encendido o apagado." }
    }

    private fun obtenerKmHora() {
        require(kmHora > 0) { "Para acelerar tienes que pisar el pedal!!" }
    }

    object EncendidoApagado {
        const val ENCENDIDO = "Encendido"
        const val APAGADO = "Apagado"
    }

}

/*
class Coche(kmHora: Int , estado: String = "Apagado") : EncendidoApagado{

    private var kmHora: Int = kmHora
        set(value) {
            obtenerKmHora()
            field = value
        }
    private var estado: String = estado
        set(value) {
            obtenerEstado()
            field = value
        }
    override fun encender(): String {
        return "Encendido"
    }


    private fun obtenerEstado(){
        require(estado == "Apagado" || estado == "Encendido") { "Sólo puede estar encendido o apagado." }
    }
    private fun obtenerKmHora(){
        require(kmHora > 0) { "Para acelerar tienes que pisar el pedal!!" }
    }

    override fun toString(): String {
        return "El Coche esta ${estado}, ha dado un acelerón de $kmHora antes de frenar."
    }
}
*/

