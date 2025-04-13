import dtos.IssueTicketResponseDto;
import dtos.IssueTicketRequestDto;
import models.Enums.VehicleType;
import repositories.GateRepository;
import controllers.TicketController;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
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