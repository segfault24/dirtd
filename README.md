# dirtd
Backend services for scraping the EVE API for market data.

## Spreadsheets in Space
Behind every great trader is a spreadsheet. Or five. As I got my start in market trading in EVE, I quickly exhausted the usefulness of a static spreadsheet and sought greater insights. Ever since, I've had an ever-evolving passion project to automatically pull the data from CCP's API(s) to find and exploit opportunities that the average trader simply would't be able to see in-game, or even with other existing tools.

While this component is most definitely the workhorse of the DIRT system, it isn't terribly interesting from a user perspective. There is no UI and it operates completely server-side in the background, going months at time without requiring human attention.

The user-facing component is the web interface: [dirt-web](https://github.com/segfault24/dirt-web)

## Design
The service is fundamentally built around the ScheduledThreadPoolExecutor, allowing the scheduling and execution of a variety of discrete, well-defined tasks in parallel. Regular tasks include pulling the market order book from public and private structures, regional price histories, public and alliance contracts, and the monthly economic report. Certain tasks operate by dynamically spawning other one-off tasks based on current circumstances, such as pulling character wallet entries for each available API key or querying for information about new items.

Running continuously without admin handholding was a primary goal. Making proper use of standard HTTP features such as ETag and error codes allows the service to reduce unnecessary querying and apply robust error handling logic when dealing with the notorious unreliability of the ESI API.

There is grpc-based interface in development that is being explored to build out certain functions, such as attaching a command line interface for performing dev/maintenance tasks without needing to restart the entire service.

## Automation
A number of previously tedious tasks are now handled automatically:
* Regularly pulls the list of all item types and market groups, removing the need to import a new static data export (SDE) from CCP every time the game is updated.
* Automatically resolves unknown character and corporation ids.
* Searches for the Monthly Economic Report (MER) zip file on the game CDN and parses the source data into the relevant database tables.

## License
This project is released under the MIT License.
