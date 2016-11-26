#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/server")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServerService {

	@Path("/status")
	@GET
	public ServerService.Status status() {
		Runtime r = Runtime.getRuntime();
		Status status = new Status(
				r.freeMemory(), 
				r.totalMemory(), 
				r.availableProcessors()
		);
		return status;
	}
	
	public static class Status {
		
		private final long freeMemory;
		private final long totalMemory;
		private final int availableProcessors;

		public Status(long freeMemory, long totalMemory, int availableProcessors) {
			super();
			this.freeMemory = freeMemory;
			this.totalMemory = totalMemory;
			this.availableProcessors = availableProcessors;
		}

		public long getFreeMemory() {
			return freeMemory;
		}

		public long getTotalMemory() {
			return totalMemory;
		}

		public int getAvailableProcessors() {
			return availableProcessors;
		}
		
	}
	
}
