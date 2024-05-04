## Solo Leveling: Gemini API Integration with Spring Boot

### Functionality

* **Player Creation (Basic):** Create a new player with a username and email.
* **Skill Testing:** Test a skill using a Gemini API prompt and retrieve results (represented as a list of `SkillTest` objects).

### V1/V1beta
https://ai.google.dev/api/rest

### Understanding the Code:

* **`GeminiInterface`:** This interface defines methods for interacting with the Gemini API:
    * `getModels` - Retrieves a list of available Gemini models. (Not used in this example)
    * `getCompletion` - Sends a prompt to a specific model and gets the generated text completion. (Used in `PlayerService.testSkill`)
* **`JsonStructure`:** This class defines various data structures used for Gemini API communication:
    * `ModelList`: Represents a list of available models with details.
    * `Model`: Details of a single Gemini model.
    * `GeminiRequest`: Structure for sending prompts to the API.
    * `GeminiResponse`: Structure of the response received from the API, containing generated content and additional information.

* **`GeminiService`:** This service class simplifies interacting with the Gemini API:
    * Provides methods to get available models (`getModels`).
    * Offers functionalities to send prompts for text completion (`getCompletion` with various options for models and image integration).
    * Includes a convenient method `getCompletion(String text)` for simple text prompts.

* **`PlayerService`:** This service handles player management and skill testing:
    * `createPlayer` - Creates a new player (basic implementation).
    * `testSkill` - This method performs the skill test:
        * Reads a baseline prompt from a file (`geminiPrompt.txt`).
        * Appends the provided skill name to the prompt.
        * Calls `geminiService.getCompletion` to send the prompt to the Gemini API and retrieve the response.
        * Attempts to parse the response into a list of `SkillTest` objects.
        * Returns the parsed list or null on failure.

* **Test Skill API (`@GetMapping(path = "/skillTest")`):**
    * This controller method handles requests to `/skillTest`.
    * It takes a `skillName` parameter in the request.
    * It calls `playerService.testSkill` with the received skill name.
    * It returns a successful response with the skill test results (if parsing succeeded and results exist) or an error response otherwise. 


### Additional Notes

* This is a basic example.
**Integration with the Gemini API requires configuration within the Google Cloud Platform. Refer to the extensive Google Cloud documentation for detailed instructions.**
