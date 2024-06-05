<h1>Microservicios agencia de viajes</h1><br>
    <p>Este repositorio contiene el <b>proyecto final</b> del Master de JAVA, que gestiona la reserva de vuelos y hoteles mediante tres microservicios diferentes.
      La aplicación utiliza una base de datos MySQL y expone sus funcionalidades a través de una API REST.</p>

<h2>Características Principales</h2><br>
    <ul>
          <li>Conexión a una base de datos MySQL.</li>
          <li>Implementación de operaciones CRUD para gestionar Hotel, Vuelo y Reserva.</li>
          <li>Relación uno a muchos entre Hotel y Reserva, Vuelo y Reserva.</li>
          <li>Exposición de endpoints para interactuar con las entidades.</li>
    </ul>

<h2>Inicio Rápido</h2><br>
    <ol>
          <li>Clonar el repositorio: 
              <pre><code>git clone https://github.com/Kosiner0/Proyecto_MasterJAVA_BeniBurdet.git</code></pre>
          </li>
          <li>Acceder al directorio del proyecto: 
              <pre><code>cd Proyecto_MasterJAVA_BeniBurdet</code></pre>
          </li>
    </ol>

<h2>Entidades</h2>
    <ol>
        <li><strong>Hotel:</strong> Representa a una entidad que tiene una o más reservas.</li>
        <li><strong>Vuelo:</strong> Representa a una entidad que tiene una o más reservas.</li>
        <li><strong>Reserva:</strong> Representa a una entidad que pertenece a un Hotel y Vuelo en concreto.</li>
    </ol>

<h2>Servicio Hotel</h2>
    <p>A partir de una tabla que contiene los campos: </p>
        <ul>
            <li>(Integer) idHotel</li>
            <li>(String) nombre</li>
            <li>(String) categoria</li>
            <li>(double) precio</li>
            <li>(boolean) disponible</li>
        </ul>
    <p>se crean los siguientes recursos:</p>
        <ul>
            <li>List<Hotel> hoteles()</li>
            <li>List<Hotel> alta(Hotel hotel)</li>
            <li>List<Hotel> eliminar(int idHotel)</li>
            <li>void actualizarCategoria(int idHotel, String nuevaCategoria)</li>
            <li>List<Hotel> hotelesDisponibles()</li>
            <li>Hotel datosHotel(String nombre)</li>
        </ul>

  <h2>Servicio Vuelo</h2>
    <p>A partir de una tabla que contiene los campos: </p>
        <ul>
            <li>(Integer) idVuelo</li>
            <li>(String) compania</li>
            <li>(String) fechaVuelo</li>
            <li>(double) precio</li>
            <li>(Integer) plazasDisponibles</li>
        </ul>
    <p>se crean los siguientes recursos:</p>
        <ul>
            <li>List<Vuelo> vuelos()</li>
            <li>List<Vuelo> alta(Vuelo vuelo)</li>
            <li>List<Vuelo> eliminar(int idVuelo)</li>
            <li>List<Vuelo> actualizarVuelo(int idVuelo, int plazas)</li>
            <li>List<Vuelo> vuelosDisponibles(int numPlazas)</li>
        </ul>

<h2>Servicio Reserva</h2>
    <p>A partir de una tabla que contiene los campos: </p>
        <ul>
            <li>(Integer) idReserva</li>
            <li>(String) nombreCliente</li>
            <li>(String) dni</li>
            <li>(Integer) idHotel</li>
            <li>(Integer) idVuelo</li>
        </ul>
    <p>se crean los siguientes recursos:</p>
        <ul>
            <li>List<Reserva> reservas()</li>
            <li>List<Reserva> reservasHotel(String nombreHotel)</li>
            <li>List<Reserva> altaVuelo(Reserva reserva, int numPersonas)</li>
            <li>List<Reserva> eliminar(int idReserva)</li>
            <li>List<Reserva> actualizarNombre(int idReserva, String newNombre)</li>
        </ul>

<h2>Endpoints</h2>
    <h3>Hoteles</h3>
    <ol>
        <li>Listar todos los hoteles
            <ul>
                <li>URL: <code>/hoteles</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
        <li>Insertar un nuevo hotel
            <ul>
                <li>URL: <code>/hoteles/alta</code></li>
                <li>Método: <code>POST</code></li>
            </ul>
        </li>
        <li>Eliminar hotel por id
            <ul>
                <li>URL: <code>/hoteles/eliminar/{idHotel}</code></li>
                <li>Método: <code>DELETE</code></li>
            </ul>
        </li>
        <li>Actualizar la categoria de un hotel por id
            <ul>
                <li>URL: <code>/hoteles/actualizar/{idHotel}/{newCategoria}</code></li>
                <li>Método: <code>PUT</code></li>
            </ul>
        </li>
        <li>Listar todos los hoteles disponibles
            <ul>
                <li>URL: <code>/hoteles/disponibles</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
        <li>Listar los datos de un hotel por nombre
            <ul>
                <li>URL: <code>/hoteles/datos/{nombre}</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
    </ol>

<h3>Vuelos</h3>
    <ol>
        <li>Listar todos los vuelos
            <ul>
                <li>URL: <code>/vuelos</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
        <li>Insertar un nuevo vuelo
            <ul>
                <li>URL: <code>/vuelos/alta</code></li>
                <li>Método: <code>POST</code></li>
            </ul>
        </li>
        <li>Eliminar vuelo por id
            <ul>
                <li>URL: <code>/vuelos/eliminar/{idVuelo}</code></li>
                <li>Método: <code>DELETE</code></li>
            </ul>
        </li>
        <li>Actualizar el numero de plazas disponibles en un vuelo por id
            <ul>
                <li>URL: <code>/vuelos/actualizar/{idVuelo}/{numPlazas}</code></li>
                <li>Método: <code>PUT</code></li>
            </ul>
        </li>
        <li>Listar todos los vuelos disponibles por numero de plazas
            <ul>
                <li>URL: <code>/vuelos/disponibles/{numPlazas}</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
    </ol>

<h3>Reservas</h3>
    <ol>
        <li>Listar todas las reservas
            <ul>
                <li>URL: <code>/reservas</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
        <li>Listar todas las reservas de un Hotel por nombre del hotel
            <ul>
                <li>URL: <code>/reservas/hotel/{nombreHotel}</code></li>
                <li>Método: <code>GET</code></li>
            </ul>
        </li>
        <li>Insertar una nueva reserva que actualiza plazas disponibles del vuelo
            <ul>
                <li>URL: <code>/reserva/alta/personas/vuelo/{numPersonas}</code></li>
                <li>Método: <code>POST</code></li>
            </ul>
        </li>
        <li>Eliminar una reserva por codigo de reserva
            <ul>
                <li>URL: <code>/reservas/eliminar/{idReserva}</code></li>
                <li>Método: <code>DELETE</code></li>
            </ul>
        </li>
        <li>Actualizar el nombre del cliente de la reserva por codigo de reserva
            <ul>
                <li>URL: <code>/reservas/actualizar/nombre/{idReserva}/{newNombre}</code></li>
                <li>Método: <code>PUT</code></li>
            </ul>
        </li>
    </ol>
