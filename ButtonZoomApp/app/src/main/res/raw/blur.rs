#pragma version(1)
#pragma rs java_package_name(com.example.buttonzoomapp)

rs_allocation inAlloc;
rs_allocation outAlloc;
int32_t width;
int32_t height;

void root(const uchar4 *v_in, uchar4 *v_out) {
    int4 sum = 0;
    for (int i = -2; i <= 2; i++) {
        for (int j = -2; j <= 2; j++) {
            int2 offset = {i, j};
            uchar4 pixel = rsGetElementAt_uchar4(inAlloc, v_in->x + offset.x, v_in->y + offset.y);
            sum += convert_int4(pixel);
        }
    }
    *v_out = convert_uchar4(sum / 25); // Average the colors to blur
}
