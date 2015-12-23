## ExtraDimensions

This module allows you to access additional display metrics on Android devices.

- Actual width and height of the screen (including elements such as soft menu bar)
- Soft menu height
- Status bar height

### Installation



### Demo

![](./demo.png)

### API

There is only one method `get(dimension: string)` that takes in a dimension name, and returns its value as a `number`.
 
Supported dimensions are:

- `REAL_WINDOW_HEIGHT` - Actual height of screen including system decor elements
- `REAL_WINDOW_WIDTH` - Actual width of screen including system decor elements
- `STATUS_BAR_HEIGHT` - Height of the status bar
- `SOFT_MENU_BAR_HEIGHT` - Height of the soft menu bar (supported on most new Android devices)
