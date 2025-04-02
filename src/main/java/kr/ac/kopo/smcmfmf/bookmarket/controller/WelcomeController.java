package kr.ac.kopo.smcmfmf.bookmarket.controller;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMethod() {
        String welcomeHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Welcome BookMarket</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle\">\n" +
                "    <button class=\"btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center\"\n" +
                "            id=\"bd-theme\"\n" +
                "            type=\"button\"\n" +
                "            aria-expanded=\"false\"\n" +
                "            data-bs-toggle=\"dropdown\"\n" +
                "            aria-label=\"Toggle theme (auto)\">\n" +
                "        <svg class=\"bi my-1 theme-icon-active\" width=\"1em\" height=\"1em\"><use href=\"#circle-half\"></use></svg>\n" +
                "        <span class=\"visually-hidden\" id=\"bd-theme-text\">Toggle theme</span>\n" +
                "    </button>\n" +
                "    <ul class=\"dropdown-menu dropdown-menu-end shadow\" aria-labelledby=\"bd-theme-text\">\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center\" data-bs-theme-value=\"light\" aria-pressed=\"false\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#sun-fill\"></use></svg>\n" +
                "                Light\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center\" data-bs-theme-value=\"dark\" aria-pressed=\"false\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#moon-stars-fill\"></use></svg>\n" +
                "                Dark\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center active\" data-bs-theme-value=\"auto\" aria-pressed=\"true\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#circle-half\"></use></svg>\n" +
                "                Auto\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<main>\n" +
                "    <div class=\"container py-4\">\n" +
                "        <header class=\"pb-3 mb-4 border-bottom\">\n" +
                "            <a href=\"/BookMarket/home\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">\n" +
                "                <svg version=\"1.0\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "                     width=\"40px\" height=\"40px\" viewBox=\"0 0 64 64\" enable-background=\"new 0 0 64 64\" xml:space=\"preserve\">\n" +
                "<g>\n" +
                "\t<path fill=\"#F9EBB2\" d=\"M56,62H10c-2.209,0-4-1.791-4-4s1.791-4,4-4h46V62z\"/>\n" +
                "    <g>\n" +
                "\t\t<path fill=\"#45AAB8\" d=\"M6,4v49.537C7.062,52.584,8.461,52,10,52h2V2H8C6.896,2,6,2.896,6,4z\"/>\n" +
                "        <path fill=\"#45AAB8\" d=\"M56,2H14v50h42h2v-2V4C58,2.896,57.104,2,56,2z\"/>\n" +
                "\t</g>\n" +
                "    <g>\n" +
                "\t\t<path fill=\"#394240\" d=\"M60,52V4c0-2.211-1.789-4-4-4H8C5.789,0,4,1.789,4,4v54c0,3.313,2.687,6,6,6h49c0.553,0,1-0.447,1-1\n" +
                "\t\t\ts-0.447-1-1-1h-1v-8C59.104,54,60,53.104,60,52z M6,4c0-1.104,0.896-2,2-2h4v50h-2c-1.539,0-2.938,0.584-4,1.537V4z M56,62H10\n" +
                "\t\t\tc-2.209,0-4-1.791-4-4s1.791-4,4-4h46V62z M56,52H14V2h42c1.104,0,2,0.896,2,2v46v2H56z\"/>\n" +
                "        <path fill=\"#394240\" d=\"M43,26H23c-0.553,0-1,0.447-1,1s0.447,1,1,1h20c0.553,0,1-0.447,1-1S43.553,26,43,26z\"/>\n" +
                "        <path fill=\"#394240\" d=\"M49,20H23c-0.553,0-1,0.447-1,1s0.447,1,1,1h26c0.553,0,1-0.447,1-1S49.553,20,49,20z\"/>\n" +
                "        <path fill=\"#394240\" d=\"M23,16h12c0.553,0,1-0.447,1-1s-0.447-1-1-1H23c-0.553,0-1,0.447-1,1S22.447,16,23,16z\"/>\n" +
                "\t</g>\n" +
                "    <path opacity=\"0.2\" fill=\"#231F20\" d=\"M6,4v49.537C7.062,52.584,8.461,52,10,52h2V2H8C6.896,2,6,2.896,6,4z\"/>\n" +
                "</g>\n" +
                "</svg>\n" +
                "                <span class=\"fs-4\">&nbsp;&nbsp;BookMarket</span>\n" +
                "            </a>\n" +
                "        </header>\n" +
                "\n" +
                "        <div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\n" +
                "            <div class=\"container-fluid py-5\">\n" +
                "                <h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신 것을 환영합니다!</h1>\n" +
                "                <p class=\"col-md-8 fs-4\">BookMarket</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row align-items-md-stretch text-cnet\">\n" +
                "            <div class=\"col-md-12\">\n" +
                "                <div class=\"h-100 p-5\">\n" +
                "                    <h2>Welcome to Web Market</h2>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row align-items-md-stretch text-cnet\">\n" +
                "            <div class=\"col-md-4\">\n" +
                "                <h4>\n" +
                "                    <svg height=\"40px\" width=\"40px\" version=\"1.1\" id=\"_x32_\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "                         viewBox=\"0 0 512 512\"  xml:space=\"preserve\">\n" +
                "<style type=\"text/css\">\n" +
                "\t.st0{fill:#000000;}\n" +
                "</style>\n" +
                "                        <g>\n" +
                "\t<path class=\"st0\" d=\"M256,0.004C114.609,0.021,0.016,114.613,0,256.004c0.016,141.39,114.609,255.974,256,255.992\n" +
                "\t\tc141.39-0.017,255.983-114.601,256-255.992C511.983,114.613,397.39,0.021,256,0.004z M406.683,406.68\n" +
                "\t\tc-38.63,38.596-91.774,62.403-150.683,62.412c-58.91-0.009-112.054-23.815-150.684-62.412\n" +
                "\t\tc-38.596-38.631-62.403-91.767-62.412-150.676c0.009-58.909,23.815-112.053,62.412-150.684\n" +
                "\t\tC143.955,66.724,197.09,42.917,256,42.909c58.909,0.008,112.045,23.815,150.683,62.412c38.598,38.631,62.404,91.775,62.413,150.684\n" +
                "\t\tC469.087,314.913,445.281,368.049,406.683,406.68z\"/>\n" +
                "                            <path class=\"st0\" d=\"M256,61.888C148.94,61.905,61.909,148.945,61.892,256.004C61.909,363.047,148.94,450.095,256,450.112\n" +
                "\t\tc107.058-0.017,194.09-87.065,194.108-194.108C450.09,148.945,363.058,61.905,256,61.888z M381.058,381.063\n" +
                "\t\tC348.981,413.116,304.795,432.95,256,432.95c-48.796,0-92.99-19.827-125.058-51.887c-32.062-32.078-51.888-76.264-51.888-125.059\n" +
                "\t\tc0-48.803,19.826-92.989,51.888-125.058C163.01,98.877,207.204,79.05,256,79.05c48.795,0,92.981,19.827,125.058,51.896\n" +
                "\t\tc32.06,32.069,51.887,76.255,51.887,125.058C432.946,304.799,413.119,348.985,381.058,381.063z\"/>\n" +
                "                            <path class=\"st0\" d=\"M198.8,226.306c-17.967,0-32.564,14.598-32.564,32.556s14.598,32.555,32.564,32.555\n" +
                "\t\tc17.949,0,32.546-14.597,32.546-32.555S216.75,226.306,198.8,226.306z\"/>\n" +
                "                            <path class=\"st0\" d=\"M313.2,226.306c-17.949,0-32.547,14.598-32.547,32.556s14.598,32.555,32.547,32.555\n" +
                "\t\tc17.966,0,32.563-14.597,32.563-32.555S331.165,226.306,313.2,226.306z\"/>\n" +
                "</g>\n" +
                "</svg>\n" +
                "                    <a href=\"/BookMarket/books\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">목록 보기</a>\n" +
                "                </h4>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <footer class=\"pt-3 mt-4 text-body-secondary border-top\">\n" +
                "            <span class=\"text-body-secondary\">&copy; 2025 BookMarket</span>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</main>\n" +
                "</body>\n" +
                "</html>";
        return welcomeHtml;
    }
}
