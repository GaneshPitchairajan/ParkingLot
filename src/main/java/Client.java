import dtos.IssueTicketResponseDto;
import dtos.IssueTicketRequestDto;
import dtos.CreateGateRequestDto;
import models.Enums.VehicleType;
import models.Gate;
import models.Enums.GateStatus;
import models.Enums.GateType;
import repositories.GateRepository;
import controllers.TicketController;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import controllers.GateController;
import services.GateService;

public class Client {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;

    private GateService gateService;
    private GateController gateController;

    public Client() {
        gateRepository = new GateRepository();
        ticketRepository = new TicketRepository();
        parkingLotRepository = new ParkingLotRepository();
        vehicleRepository = new VehicleRepository();

        gateService = new GateService(gateRepository);
        gateController = new GateController(gateService);
    }

    public void addGates() {
        CreateGateRequestDto gateRequest1 = new CreateGateRequestDto();
        gateRequest1.setGateNumber(1);
        gateRequest1.setGateType(GateType.ENTRY);
        gateRequest1.setGateStatus(GateStatus.OPENED);
        gateController.addGate(gateRequest1);

        CreateGateRequestDto gateRequest2 = new CreateGateRequestDto();
        gateRequest2.setGateNumber(2);
        gateRequest2.setGateType(GateType.EXIT);
        gateRequest2.setGateStatus(GateStatus.OPENED);
        gateController.addGate(gateRequest2);

        // Assign gates to parking lot with id 1
        //parkingLotRepository.setGatesForParkingLot(1L, gateRepository.getAllGates());
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.addGates();
        TicketService ticketService = new TicketService(
                client.gateRepository,
                client.vehicleRepository,
                client.parkingLotRepository,
                client.ticketRepository
        );
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setOwnerName("Karthikeyan");
        issueTicketRequestDto.setVehicleNumber("KA19293");
        issueTicketRequestDto.setVehicleType(VehicleType.LARGE);

        IssueTicketResponseDto responseDto = ticketController.issueTicket(issueTicketRequestDto);
    }
}